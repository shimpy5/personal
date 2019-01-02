import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReadWriteLock {
	private Lock m_rwlock;
	private Condition m_waitObj;
	//private Condition m_waitforwriters;
	private int m_readerCount;
    private int m_waitingreaders;
	private int m_waitingwriters;
	private int m_writer;
	
	public ReadWriteLock()
	{
		m_rwlock = new ReentrantLock();
		m_waitObj = m_rwlock.newCondition();
		//m_waitforwriters = m_rwlock.newCondition();
		m_readerCount = 0;
		m_waitingreaders = 0;
		m_waitingwriters = 0;
		m_writer = 0;
	}
	public void readLock() throws InterruptedException
	{
		m_rwlock.lock();
		m_waitingreaders++;
		while (m_waitingwriters > 0 || m_writer == 1)
		{
			m_waitObj.wait();
		}
		m_waitingreaders--;
		m_readerCount++;
		m_rwlock.unlock();
	}
	
	public void readUnlock() throws InterruptedException
	{
		m_rwlock.lock();
		m_readerCount --;
		/*if(m_readerCount > 0 || (m_waitingwriters == 0 && m_waitingreaders > 0))
		{
			m_waitforwriters.notify();
		}
		else if (m_readerCount == 0 && m_waitingreaders == 0)
		{
			m_waitforreaders.notify();
		}*/
		m_waitObj.notifyAll();
		m_rwlock.unlock();		
	}
	
	public void writeLock() throws InterruptedException
	{
	  m_rwlock.lock();
	  m_waitingwriters++;
	  while (m_readerCount > 0 || m_writer == 1)
	  {
		  m_waitObj.wait();
	  }
	  m_waitingwriters--;
	  m_writer = 1;
	  m_rwlock.unlock();
	}
	
	public void writeUnlock()
	{
		m_rwlock.lock();
		m_writer = 0;
		/*if(m_waitingwriters > 0)
		{
			m_waitforreaders.notify();
		}
		else
		{
			m_waitforwriters.notify();
		}*/
		m_waitObj.notifyAll();
	    m_rwlock.unlock();
	}

}
