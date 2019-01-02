import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class PersistentConnectionServer {

	ServerSocket m_serverSock = null;
	
	class MyTask implements Runnable
	{
		Socket m_clntSock;
		MyTask(Socket clntSock)
		{
			m_clntSock = clntSock;
		}
		public void run()
		{
			try
			{
			boolean keepConAlive = false;
			do
			{
			 BufferedReader readerStream =  new BufferedReader (new InputStreamReader(m_clntSock.getInputStream()));
			 String line = readerStream.readLine();
			 keepConAlive = false;
			 while (line != null)
			 {
			  String [] tokens = line.split(" ");
			  if(tokens[0].matches("KeepAlive:true"))
			  {
				  keepConAlive = keepConAlive | true;
			  }
			 }
			  
			} while (keepConAlive);
			}
			catch (IOException e)
			{
				e.printStackTrace();
				
			}
			finally
			{
				
			}
		}
	}
	public void init() throws IOException
	{
		m_serverSock = new ServerSocket(5433);
		ExecutorService tpool = Executors.newFixedThreadPool(5);
		
		while (true)
		{
			Socket clntSock = m_serverSock.accept();
            tpool.submit(new MyTask(clntSock));	    
		
		}
		
	}
	public void terminate() throws IOException
	{
		m_serverSock.close();
	}

}
