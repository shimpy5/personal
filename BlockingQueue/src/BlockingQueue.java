import java.util.LinkedList;
import java.util.Queue;

class MyTaskAdd implements Runnable
{
	private BlockingQueue m_blkq = null;
	MyTaskAdd(BlockingQueue inst)
	{
		m_blkq = inst;
	}
	
	public void run()
	{
	  try
	  {
		int counter = 0;
		while (counter < 10)
		{
			m_blkq.add(this);
			System.out.printf("Add Task counter %d\n", counter);
			counter++;
		}
	  }
	  catch(InterruptedException e)
	  {
		  System.out.println("InterruptedException Caught in remove");
	  }
	  finally
	  {
		  System.out.println("No action to be taken in remove");
	  }
		
	}
}

class MyTaskRemove implements Runnable
{
	private BlockingQueue m_blkq = null;
	MyTaskRemove(BlockingQueue inst)
	{
		m_blkq = inst;
	}
	
	public void run()
	{
	  try
	  {
		int counter = 0;
		while (counter < 10)
		{
			m_blkq.remove();
			System.out.printf("Remove Task counter %d\n", counter);
			counter++;
		}
	  }
	  catch(InterruptedException e)
	  {
		  System.out.println("InterruptedException Caught in remove");
	  }
	  finally
	  {
		  System.out.println("No action to be taken in remove");
	  }
		
	}
}
class MyThread extends Thread
{
	private Runnable m_task = null;
	
	MyThread(Runnable task)
	{
	    m_task = task;	
	}
	public void run()
	{
		m_task.run();
	}
}
public class BlockingQueue {
	
	private Queue<Object> m_blkqueue;
	private int m_capacity;
	
	BlockingQueue(int capacity)
	{
		m_blkqueue =  new LinkedList<Object>();
		m_capacity = capacity;
	}
	public synchronized void add(Object o) throws InterruptedException
	{
		if (m_blkqueue.size() == m_capacity)
		{
			System.out.println("Waiting in add");
			wait();
		}
		notifyAll();
		m_blkqueue.add(o);
	}
	public synchronized Object remove() throws InterruptedException
	{
		if(m_blkqueue.size() == 0)
		{
			System.out.println("Waiting in remove");
			wait();
		}
		notifyAll();
		return m_blkqueue.remove();
	}
	public int size()
	{
		return m_blkqueue.size();
	}
	public int capacity()
	{
		return m_capacity;
	}

	
	public static void main(String args[])
	{
		BlockingQueue myblkQueue =  new BlockingQueue(5);
		MyTaskAdd addTask = new MyTaskAdd(myblkQueue);
		MyThread addThread =  new MyThread(addTask);
		addThread.start();
		
		MyTaskRemove remTask =  new MyTaskRemove(myblkQueue);
		MyThread remThread = new MyThread(remTask);
		remThread.start();
		//TreeMap mp = new TreeMap();
		//Time = new Time();
		//Random rand = new Random(time)
	}
}


