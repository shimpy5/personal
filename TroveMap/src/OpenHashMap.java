
public class OpenHashMap {
	private long[] keys;
	private long[] values;
	
	OpenHashMap(int capacity)
	{
		keys= new long[capacity];
		values = new long[capacity];
		for (int index = 0; index <keys.length; index++)
		{
			keys[index] = -1;
		}
		for (int index = 0; index <values.length; index++)
		{
			values[index] = -1;
		}
	}
	
	public void insert(long key, long value)
	{
		int index = (int)(key % (keys.length));
		while(keys[index] != -2 && keys[index] != -1 && keys[index] != key)
		{
			index = (index + 1) % (keys.length);
		}
		keys[index] = key;
		values[index] = value;
	}
	
	public long search(long key)
	{
		int index = (int) (key % (keys.length));
		int sizeCounter = 0;
		boolean keyNotFound = false;
		while(keys[index] != key)
		{
			if(keys[index] == -1  && sizeCounter > keys.length)
			{
				keyNotFound = true;
				break;
			}
			index = (index+1) % keys.length;
			sizeCounter++;
		}
		if(keyNotFound)
		{
			return -1;
		}
			
		return values[index];
	}
	
	boolean remove(long key)
	{
		int index = (int)(key%(keys.length));
		int sizeCounter = 0;
		boolean keyNotFound = false;
		
		while(keys[index] != key)
		{
			if(keys[index] == -1  && sizeCounter > keys.length)
			{
				keyNotFound = true;
				break;
			}
			index = (index+1) % keys.length;
			sizeCounter++;
		}
		if(keyNotFound == true)
		{
		   return false;	
		}
		keys[index] = -2;
		values[index] = -2;
		return true;
	}
	void print()
	{
		for(int index = 0; index < keys.length; index++)
		{
			System.out.printf("%d \t", keys[index]);
			System.out.printf("%d", values[index]);
			System.out.println();
		}
	}
	
	public static void main(String args[])
	{
		OpenHashMap mp = new OpenHashMap(30);
		mp.insert(10, 100);
		mp.insert(20, 200);
		mp.insert(20, 300);
		mp.remove(20);
		long value = mp.search(20);
		System.out.println(value);
		mp.print();
	}

}
