import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HelloWorld {
	
	private HashMap<String, Integer> domainToHits = new HashMap<String, Integer>();
	
	public void TokenizeAndAddToMap(String [] counts)
	{
		for( String str : counts)
		{
			String []  arrayStr = str.split(",");
			Integer count = Integer.parseInt(arrayStr[0]);
			String restOfString = arrayStr[1];
			if(domainToHits.containsKey(restOfString))
			{
				Integer val = domainToHits.get(restOfString);
				val = val + count;
				domainToHits.put(restOfString, val);
			}
			else
			{
				domainToHits.put(restOfString, count);
			}
			int dotIndex = restOfString.indexOf(".");
			while (dotIndex != -1)
			{
				restOfString = restOfString.substring(dotIndex+1);
				if(domainToHits.containsKey(restOfString))
				{
					Integer val = domainToHits.get(restOfString);
					val = val + count;
					domainToHits.put(restOfString, val);
				}
				else
				{
					domainToHits.put(restOfString, count);
				}
				
				dotIndex = restOfString.indexOf(".");
			}
			
		}
		
	}
	
	void print()
	{
		Set<Map.Entry<String, Integer>> s = domainToHits.entrySet();
		for(Map.Entry<String, Integer> entry : s )
		{
			System.out.printf("%s\t%d", entry.getKey(), entry.getValue());
			System.out.println();
		}
		Collection c = domainToHits.values();
		List<Integer>[] l = new ArrayList<Integer>[];
		
	}
	public static void main (String args[])
	{
		//System.out.println("Hello World");
		//String abc = new String();
		//abc="999";
		String[] counts = { "1000,google.com",
				"2000,mail.yahoo.com",
				"3000,abc.mail.google.com"
		};
		HelloWorld worldNew = new HelloWorld();
		worldNew.TokenizeAndAddToMap(counts);
		worldNew.print();
	}

}
