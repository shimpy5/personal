import java.util.concurrent.atomic.AtomicBoolean;

public class Lock {
	
	public void lock() throws InterruptedException
	{
	    if(m_AtomicBool.compareAndSet(false, true))
		{
	    	threadId = Thread.currentThread().getId();
		    return;
		}
		if (Thread.currentThread().getId() == threadId)
			return;
	    wait();
		
	}
	public void unlock()
	{
		m_AtomicBool.compareAndSet(true, false);
		threadId = 0;
		notify();
	}
	public boolean trylock()
	{
		if(m_AtomicBool.compareAndSet(false, true))
		{
			threadId = Thread.currentThread().getId();
		    return true;
		}
		if (Thread.currentThread().getId() == threadId)
			return true;
		return false;
	}
	Lock()
	{
		m_AtomicBool = new AtomicBoolean();
		threadId = 0;
	}
	
	private AtomicBoolean m_AtomicBool;
	private long threadId;

}
