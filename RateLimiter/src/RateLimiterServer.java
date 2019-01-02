import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiterServer {
	private ServerSocket sSock = null;
//	private AtomicInteger m_requestsHandled = new AtomicInteger();
	ConcurrentHashMap<String, Integer> m_hmapClientRate;
	private int m_batchIncr = 0;
	private List<String> m_hostnamelist;
	private ExecutorService m_execService = null;
	
    public RateLimiterServer(List<String> hostnamelist)
    {
    	m_hostnamelist = hostnamelist;
    	m_execService = Executors.newFixedThreadPool(5);
    	m_hmapClientRate = new ConcurrentHashMap<String,Integer>(100000, (float) 0.75);
    	//m_requestsHandled.set(0);
    }
	public void init() throws IOException
	{
		sSock = new ServerSocket(2434);
		while(true)
		{
		 Socket clntSock = sSock.accept();
		 m_execService.submit(new SocketJob(clntSock));
		}
	}
	public void setBatchIncrement(int value)
	{
		m_batchIncr = value;
	}
	
	
	public synchronized void batchIncrement(String clientId)throws UnknownHostException, IOException
	{
		String rateForClient =  null;
		if (m_hmapClientRate.get(clientId) != null)
		{
			Integer rate = m_hmapClientRate.get(clientId);
		    rate+= m_batchIncr;
		    rateForClient =  new String(Integer.toString(rate));
		    m_hmapClientRate.put(clientId, rate);
		}
		//m_requestsHandled.addAndGet(m_batchIncr);
		Socket cs = null;
		for (String hname: m_hostnamelist)
		{
			try {
		    System.out.println("batch increment");
			cs = new Socket(hname, 2434);
			DataOutputStream optStream = new DataOutputStream(cs.getOutputStream());
			BufferedWriter writeTextStream = new BufferedWriter( new OutputStreamWriter(optStream));
			writeTextStream.write("UPDATE RATE ");
			StringBuilder client_rate = new StringBuilder();
			client_rate.append(clientId);
			client_rate.append(" ");
			client_rate.append(rateForClient);
			
			//writeTextStream.append(Integer.toString(intStr));
			writeTextStream.append(rateForClient.toString());
			writeTextStream.newLine();
			writeTextStream.close();
			//System.out.println("batch increment");
			}
			catch(UnknownHostException e)
			{
				
			}
			finally{
			  if( cs != null)
			  {
			
				cs.close();
			  }
			}
		}
	}
	public void bootstrap(String clientId) throws UnknownHostException, IOException
	{
		Socket clnt = null;
		for (String hname: m_hostnamelist)
		{
		  try {
			    clnt = new Socket(hname, 2434);
				BufferedWriter dataWriter = new BufferedWriter(new OutputStreamWriter(new DataOutputStream(clnt.getOutputStream())));
				dataWriter.write("GET RATE");
				dataWriter.newLine();
				dataWriter.close();
				DataInputStream stream = new DataInputStream(clnt.getInputStream());
				//m_requestsHandled.set(stream.readInt());
				if (m_hmapClientRate.get(clientId) != null)
				{
					Integer rate = m_hmapClientRate.get(clientId);
				    rate+= m_batchIncr;
				    //rateForClient =  new String(Integer.toString(rate));
				    m_hmapClientRate.put(clientId, rate);
				}
				
				stream.close();
			}
			catch (IOException excp)
			{
				 
				
			}
			finally
			{
				if (clnt != null)
				{
					clnt.close();
				}
			}
		}
		
	}
	public void terminate() throws IOException
	{
		if (sSock != null)
		{
			m_execService.shutdown();
			sSock.close();
		}
	}
	class SocketJob implements Runnable
	{
		private Socket m_clntSock;
		
		SocketJob(Socket clntSock)
		{
			m_clntSock = clntSock;
		}
		public void run()
		{
			DataInputStream dataInp = null;
			BufferedReader reader = null;
			DataOutputStream outputStream = null;
			BufferedWriter writer = null;
			
			try
			{
			   dataInp = new DataInputStream(m_clntSock.getInputStream());
			   reader =  new BufferedReader(new InputStreamReader(dataInp));
			   outputStream = new DataOutputStream (m_clntSock.getOutputStream());
			   writer = new BufferedWriter (new OutputStreamWriter(m_clntSock.getOutputStream()));
			     if (reader != null)
			     {
			    	 String lineStr = reader.readLine();
			    	 if (!lineStr.isEmpty())
			    	 {
			    	   String [] tokens = lineStr.split(" ");
			    	   if( tokens[0].matches("GET") == true && tokens[1].matches("RATE") == true)
			    	   {
			    		   outputStream = new DataOutputStream(m_clntSock.getOutputStream());
			   			   Integer intStr = new Integer(m_requestsHandled.get());
			   			   System.out.println("In get rate");
			   			   outputStream.writeInt(intStr.intValue());
			   			   outputStream.flush();
			   			   outputStream.close();
			    	   }
			    	   else if ( tokens[0].matches("UPDATE") == true && tokens[1].matches("RATE") == true)
			    	   {
			    		   System.out.println("In Update rate %s");
			    		   System.out.println(tokens[2]);
			    		   Integer counter = Integer.parseInt(tokens[2]);
			    		   m_requestsHandled.addAndGet(counter.intValue());
			    		   System.out.println(counter);
			    		   writer.write("ACK");
			    		   writer.flush();
			    		   writer.close();
			    	   }
			    	 }
			     } 
			     m_clntSock.close();
			}
			catch(IOException excp)
			{
				
			}
			finally
			{
				System.out.println("Finally Called for thread");
			}
		}
		
	}
	
}
