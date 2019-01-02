import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class Bitly {
	
	void generateRandomNumberInRange(int min, int max)
	{
	   int a[] = new int[10];
	   
	   a[0] = min;
       for (int i = 1 ; i < 10 ; i++)
       {
    	   System.out.println(a[i]);
       }
	}
	public void IterateListReverseAndSort()
	{
		List<String> revlist = new LinkedList<String>();
		revlist.add("abc");
		revlist.add("ghi");
		revlist.add("ijk");
		revlist.add("def");
		ListIterator<String> revItr = revlist.listIterator(revlist.size());
		while(revItr.hasPrevious())
		{
			System.out.println(revItr.previous());
		}
		Collections.sort(revlist);
		try {
			
			for(String revt : revlist)
			{
				System.out.println(revt);
				
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			System.out.println("Learning Java");
		}
		
	}
	public static List<String> instanceFunction()
	{
		return new LinkedList<String>();
		
	}
	
	public void stringHandler(String [] array)
	{
		for ( String str : array)
		{
			String[] myarr = str.split(",");
			for(String tp1 : myarr)
			{
			 System.out.println(tp1);
			 System.out.println(tp1.trim());
			}
			
			int index = str.indexOf(",");
			while(index != -1)
			{
				String type1 = str.substring(0, index);
				System.out.printf("First part of String %s\n", type1);
                 str = str.substring(index + 1);
                 
                System.out.printf("Rest of the String %s\n", str);
               /* int indexlast = type2.lastIndexOf(",");
                if (indexlast != -1)
                {
                	System.out.printf("Last part of String %s\n", type2.substring(indexlast + 1));
                }*/
                System.out.println(str + "abc");
                System.out.println(str.replace("a", "the"));
                index = str.indexOf(",");
			}
		}
		
	}
	
	public static void main(String args[])
	{
		Bitly bit = new Bitly();
		String array[] = {"I, am  a , name",
				          "You, are a , trouble",
				          "This, is a , new thing"
		                  };
		bit.generateRandomNumberInRange(10, 20);
		int mynumber = 1234;
		System.out.println(String.valueOf(mynumber));
		bit.stringHandler(array);
		
		Scanner scr = new Scanner(System.in);
		System.out.println("Get new String :");
		String inputStr = scr.next();
		System.out.println(inputStr);
		
		while(!inputStr.equals("EOF"))
		{
			inputStr = scr.nextLine();
			System.out.println(inputStr);
		}
		//bit.generateRandomNumberInRange(10, 20);
		bit.IterateListReverseAndSort();
	    List<String> strlist = bit.instanceFunction();
		strlist.add(new String("Shimpy"));
		System.out.println(strlist.get(0));
		scr.close();
		
	}

}
