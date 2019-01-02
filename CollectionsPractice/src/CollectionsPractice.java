
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


public class CollectionsPractice {
	
	final static HashMap<String, String> mp;
    static
	{
		mp = new HashMap<>();
	}
	CollectionsPractice()
	{
		
	}
	void TryNoPut()
	{
		
		HashMap<String,ArrayList<String>> mp = new HashMap<>();
		ArrayList<String> alist = new ArrayList<>();
		
		String newStr = new String("Gupta");
		alist.add(newStr);
		mp.put("shimpy",alist);
		ArrayList<String> mylist = mp.get("shimpy");
		String newStr1 = new String("Gupta2");
		mylist.add(newStr1);
		for(Map.Entry<String,ArrayList<String>> e: mp.entrySet())
		{
			for(String str : e.getValue())
			{
				System.out.println(str);
			}
		}
		Set<String> keySet = mp.keySet();
		System.out.println(mp.keySet().size());
		for(String key: keySet)
		{
			mp.remove(key);
		}
		System.out.println(mp.keySet().size());
	}
	
	
	public static void main(String args[])
	{
		LinkedList<String> mylist = new LinkedList<String>();
		mylist.add("Hello");
		
		LinkedList<String> mylist2 = new LinkedList<String>();
		mylist2.add("World");
		
		LinkedList<LinkedList<String>> listOfArrlists = new LinkedList<LinkedList<String>>();
		listOfArrlists.add(mylist);
		listOfArrlists.add(mylist2);
		
		for(LinkedList<String>list : listOfArrlists)
		{
			for(String xy : list)
			{
				System.out.println(xy);
				
			}
		}
		CollectionsPractice cp = new CollectionsPractice();
		cp.TryNoPut();
	}

}
