import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StringPool{
	ConcurrentHashMap<String, String> poolMap;
	
	public StringPool(List<String> initialSet)
	{
		poolMap = new ConcurrentHashMap<String, String>(1000000, (float) 0.75);
		for (String str : initialSet)
		{
			String upperCaseRef = str.toUpperCase();
			poolMap.put(upperCaseRef, upperCaseRef);
			
		}
			
	}
	
	public String getRef(String incomingRef)
	{
		if(incomingRef != null)
		{
		 String upperCaseRef = incomingRef.toUpperCase();	
		 String existingRef = poolMap.get(upperCaseRef);
		 if(existingRef == null)
		 {
			 //String newRef = new String(upperCaseRef);
		     poolMap.put(upperCaseRef, upperCaseRef);
		     return upperCaseRef;
		 }
		 return existingRef;
		}
		return null;
	}

}
