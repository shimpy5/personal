package LRUCache;

import java.util.LinkedHashMap;



public class LRUCache <Key, Value>{
	
	
	public LRUCache()
	{
	    m_hashmap = new LinkedHashMap<Key,Value>();
	}
	public void add(Key K, Value v)
	{
		m_hashmap.put(K, v);
	}
    public Value get(Key K)
    {
        return m_hashmap.get(K);
    }
        
    public boolean delete(Key K, Value v)
    {
        return m_hashmap.remove(K, v);
    }
    public static void main(String args[])
    {
    	LRUCache<String, String> mylrucache = new LRUCache<String, String>();
    	String strKey1 = new String("Shimpy");
    	String strValue1 = new String("Gupta");
    	String strKey2 = new String("Dhruv");
    	String strValue2 = new String("Gupta");
    	mylrucache.add(strKey1, strValue1);
    	mylrucache.add(strKey2, strValue2);
    	
    	String strVale = mylrucache.get(strKey2);
    	System.out.println(strVale);
    	
    }
   private LinkedHashMap<Key, Value> m_hashmap;
	

}
