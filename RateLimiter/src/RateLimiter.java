import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
class MyBatchIncrJob implements Runnable
{
	private RateLimiter m_rlInst;
	
	MyBatchIncrJob(RateLimiter rlInst)
	{
		m_rlInst = rlInst;
	}
	
	public void run()
	{
		try
		{
		 m_rlInst.batchIncrement();
		 
		}
		catch(IOException exp)
		{
			System.out.println("Batch Increment Job failed");
		}
		finally
		{
			System.out.println("Batch job finally Increment");
		}
		
	}
}
class RLFirstValue implements Runnable
{
	private RateLimiter m_rlInst;
	
	RLFirstValue(RateLimiter rlInst)
	{
		m_rlInst = rlInst;
	}
	
	public void run()
	{
		try
		{
		 m_rlInst.bootstrap();
		}
		catch(IOException exp)
		{
			System.out.println("First Value Job failed");
		}
		finally
		{
			System.out.println("Batch job finally FirstValue");
		}
		
	}
}
class RLSStart implements Runnable
{
	private RateLimiter m_rlInst;
	
	RLSStart(RateLimiter rlInst)
	{
		m_rlInst = rlInst;
	}
	
	public void run()
	{
		try
		{
		 m_rlInst.init();
		}
		catch(IOException exp)
		{
			System.out.println("Start Job failed");
		}
		finally
		{
			System.out.println("Start job finally Init");
		}
		
	}
	
}
public class RateLimiter {

	RateLimiterServer m_rlServer = null;

    
    RateLimiter(List<String> arrayl)
    {
    	m_rlServer = new RateLimiterServer(arrayl);
    	m_rlServer.setBatchIncrement(100);
    	
    }
    
    public void batchIncrement() throws IOException
    {
    	m_rlServer.batchIncrement();
    }
    public void bootstrap() throws IOException
    {
    	m_rlServer.bootstrap();
    }
    public void init() throws IOException
    {
    	m_rlServer.init();
    	
    }
	

	public static void main(String args[]) throws IOException, InterruptedException
	{
		List<String> hostnameList = new ArrayList<String>();
		String hostname="localhost";
		hostnameList.add(hostname);
		RateLimiter rl = new RateLimiter(hostnameList);
		Thread p1 = new Thread(new RLSStart(rl));
		p1.start();
		
		Thread px = new Thread(new RLFirstValue(rl));
		px.start();
		
		Thread.sleep(2000);
		Thread p2 = new Thread(new MyBatchIncrJob(rl));
		p2.start();
	}
}
