
public class Semaphore {

	//private Lock [] m_Lock;
	//private Condition [] m_semaphore;
	private int counter = 0;
	private int m_numOfResources = 0;
	
	
	public Semaphore(int numOfPermits)
	{
		counter = numOfPermits - 1;
		m_numOfResources = numOfPermits;
		//m_Lock = new Lock[m_numOfResources];
		//m_semaphore = new Condition[m_numOfResources];
		/*for ( int i = 0; i < m_numOfResources ; i++)
		{
			m_Lock[i] = new ReentrantLock();
			m_semaphore[i] = m_Lock[i].newCondition();
		}*/
	}
	
	public synchronized void acquire()
	{
		try {
		 while (counter <= 0)
		 {
			wait();
		 }
		 --counter;
		 notify();
		}
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 
		 }
		
	}
	public synchronized void release() throws InterruptedException
	{
		try {
		while ( counter == m_numOfResources)
		{
			wait();	
		}
		++counter;
		notify();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
	}	
	
}
