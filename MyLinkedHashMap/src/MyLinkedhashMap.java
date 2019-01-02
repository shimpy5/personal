import java.util.HashMap;

public class MyLinkedhashMap<K, V>{
	
	private HashMap<K, Node<K,V>> m_hmap = null;
	private Node<K,V> m_HeadRef = null;
	private Node<K,V> m_TailRef = null;
	private int m_capacity;
	
	public MyLinkedhashMap()
	{
		m_capacity = 10;
		m_HeadRef = null;
		m_TailRef = m_HeadRef;
		m_hmap = new HashMap<K,Node<K,V>>(m_capacity);
	
	}
	public void add(K key, V val)
	{
		Node<K,V> tailNode = new Node<K, V>(key, val);
		tailNode.setTimeStamp(System.currentTimeMillis());
		m_hmap.put(key, tailNode);
		
		if(m_HeadRef == null && m_TailRef == null)
		{
		  m_HeadRef = tailNode;
		}
		else
		{
			tailNode.setPrevNode(m_TailRef);
			m_TailRef.setNextNode(tailNode);
			m_TailRef = tailNode;
		}	
	}
	
	public V get(K key)
	{
		Node<K,V> n1Ref = m_hmap.get(key);
		if (n1Ref != null)
		{
		 n1Ref.setTimeStamp(System.currentTimeMillis());
		 if ( n1Ref != null && n1Ref.getPrevNode() != null)
				n1Ref.getPrevNode().setNextNode(n1Ref.getNextNode());
		 if( n1Ref != null && n1Ref.getNextNode() != null)
				n1Ref.getNextNode().setPrevNode(n1Ref.getPrevNode());
		 if(m_HeadRef != null)
		 {
			 n1Ref.setNextNode(m_HeadRef);
			 m_HeadRef.setPrevNode(n1Ref);
		 }
		 m_HeadRef = n1Ref;
		 return n1Ref.getValue();
		}
		return null;		
	}
	
	public boolean remove(K key)
	{
		Node<K,V> n1Ref = m_hmap.get(key);
		if(n1Ref != null)
		{
		 if ( n1Ref != null && n1Ref.getPrevNode() != null)
				n1Ref.getPrevNode().setNextNode(n1Ref.getNextNode());
		 if( n1Ref != null && n1Ref.getNextNode() != null)
				n1Ref.getNextNode().setPrevNode(n1Ref.getPrevNode());
		 m_hmap.remove(key);
		 return true;
		}
		return false;
	} 
	
	/*public boolean remove (K key, V value)
	{
		Node<K,V> n1Ref = m_hmap.
		if(n1Ref != null)
		{
		}
	}*/

}
