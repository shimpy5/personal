class ABC
{
	String name = null;
	static void swap(ABC one, ABC two)
	{
		ABC temp = one;
	    one = two;
	    two = temp;
	}
	boolean isPalindrome(String str)
	{
		if(str == null)
			return true;
		StringBuilder sb = new StringBuilder(str);
		System.out.println(sb);
		System.out.println(sb.reverse());
		System.out.println(str.equals(sb.toString()));
		return true;
	
	}
}
public class OneDArray {
	int [] intArrayObjRef = null;
	String [] stringArrayObjRef = null;
 	
	public static void main (String args[])
	{
		OneDArray obj = new OneDArray();
		obj.intArrayObjRef = new int[4];
		obj.stringArrayObjRef = new String[4];
		
		for (int index = 0; index < obj.intArrayObjRef.length; index++)
		{
			obj.intArrayObjRef[index] = 2;
			obj.stringArrayObjRef[index] = "Shimpy";
			
		}
		
		for (int index = 0; index < obj.intArrayObjRef.length; index++)
		{
			System.out.println(obj.intArrayObjRef[index]);
			System.out.println(obj.stringArrayObjRef[index]);
			
		}
		
		int [] arr = new int [4];
		System.out.println(arr.getClass().getName());
		System.out.println(arr.getClass().getSimpleName());
		
		
		
		ABC a1 = new ABC();
		a1.name = new String("SShimpy");
		char[] arrchar = a1.name.toCharArray();
		if(arrchar[0] == arrchar[1])
		{
		  System.out.println("True");	
		}
		else
		{
		  System.out.println("False");
		}
		ABC a2 = new ABC();
		a2.name = new String("Gupta");
		ABC.swap(a1, a2);
		System.out.println(a1.name);
		System.out.println(a2.name);
		String stra1 = new String("madam");
		if(a1.isPalindrome(stra1))
		{
			System.out.println("True");
		}
		
		
	}

}
