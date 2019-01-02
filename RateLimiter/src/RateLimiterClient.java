import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class RateLimiterClient {
	
	private List<String> m_hostnamelist;
	private int m_counter = 0;
	
	private RateLimiterClient(List<String> hostname, int maxRequests) throws IOException
	{
		m_hostnamelist = hostname;
	}
	
	public synchronized void batchIncrement()throws UnknownHostException, IOException
	{
		/*if( m_counter <=  m_maxRequests )
		{
			m_counter++;
		}
		else
		{
			m_maxRequestsReached = true;
		}*/
		m_counter += 1;
		for (String hname: m_hostnamelist)
		{
			Socket cs = new Socket(hname, 2434);
			DataOutputStream optStream = new DataOutputStream(cs.getOutputStream());
			optStream.writeInt(m_counter);
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			String sCurAck = bufReader.readLine();
			while(sCurAck != null)
			{
				System.out.println(sCurAck);
				sCurAck = bufReader.readLine();
			}
			cs.close();
		}
		
		m_counter = 0;
		
	}
	
	public static void main(String args[]) throws IOException
	{
		List<String> hostName = new ArrayList<String>();
		hostName.add("localhost");
		RateLimiterClient rateLimiter = new RateLimiterClient(hostName, 2);
		rateLimiter.batchIncrement();
		
	}

}
