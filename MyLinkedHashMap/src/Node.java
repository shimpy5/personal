public class Node<K, V>
{
	private K m_keyRef;
	private V m_ValRef;
	private long m_timestamp;
	private Node<K, V> m_refNext = null;
	private Node<K, V> m_refPrev = null;
	
	public Node()
	{
		m_keyRef = null;
		m_ValRef = null;
		m_refNext = null;
		m_refPrev = null;
				
	}
	public Node(K key, V val)
	{
		m_keyRef = key;
		m_ValRef = val;
		m_refNext = null;
		m_refPrev = null;
	}
	public Node<K, V> getPrevNode()
	{
		return m_refPrev;
	}
	
	public Node<K,V> getNextNode()
	{
		return m_refNext;
	}
	
	public void setNextNode(Node<K, V> nextN)
	{
		m_refNext = nextN;
	}
	
	public void setPrevNode(Node<K,V> prevN)
	{
		m_refPrev = prevN;
	}
	public K getKey()
	{
		return m_keyRef;
	}
	public V getValue()
	{
		return m_ValRef;
	}
	public void setTimeStamp(long timestamp)
	{
		m_timestamp = timestamp;
	}
	public long getTimeStamp()
	{
		return m_timestamp;
	}
	
}


