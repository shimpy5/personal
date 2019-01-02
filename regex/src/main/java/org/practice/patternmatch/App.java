package org.practice.patternmatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Hello world!
 *
 */
public class App 
{
	void patternMatch(String url) throws IOException
	{
		URL urlClass = new URL(url);
		URLConnection myconn = urlClass.openConnection();
		BufferedReader myRdr = new BufferedReader(new BufferedReader(new InputStreamReader(myconn.getInputStream())));
		String lineContent = myRdr.readLine();
		
		while(lineContent != null)
		{
			String pattern="@[a-z]+.[a-z] {3} | @[a-z]+.[a-z] {2}";
			if (lineContent.matches(pattern) == true)
			{
				System.out.println("Match found");
			}
					
		}
	}
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
        //int[] a = {1,2,3};
        String str = new String("Hello World 123 345 ab123c@emc.com!");
        Pattern p1 = Pattern.compile("\\p{Alnum}+@\\p{Alnum}+.([a-z]){3}");
        Matcher m = p1.matcher(str);
        while(m.find())
        {
        	int startIndex = m.start();
        	int endIndex = m.end();
        	
        	System.out.printf("Words are : %s\n", str.substring(startIndex, endIndex));
        }
        Double d1 = new Double(1.0);
        Double d2 = new Double(1.0000000000000001);
        
       
        //Math.power(dou)
        if(d1.equals(d2))
        {
         System.out.printf("Equality result is true\n");
        }
        
         System.out.printf("Comparison is : %d", d1.compareTo(d2));
         BitSet bs1 = new BitSet();
         bs1.set(0);
         bs1.set(4);
         bs1.set(5);
         
         System.out.printf("\nBoolean value is %s", bs1.get(4));
         System.out.println(bs1);
         try
         {
        	 String strx = new String("(\\A(w+)|\\b(\\w+))(\\W+\\1\\b)");
	         Pattern p2 = Pattern.compile(strx, Pattern.CASE_INSENSITIVE);
	         
	         String charS = new String("This this is is a good this thing");
	         Matcher m1 = p2.matcher(charS);
	         int x = m1.groupCount();
	         System.out.println(x);
	         while(m1.find())
	         {
	        	 for(int i =0; i < x; i++)
	        	 {
	        		 if(m1.group(i) != null)
	        		 {
	        			 System.out.printf("\nMatching group is %d\n", i);
	        			 System.out.printf("Matching subsequence is %s", charS.substring(m1.start(i), m1.end(i)));
	        		 }
	        	 }
	        	 //System.out.println(m1.group(3));
	         }
         }
         catch(PatternSyntaxException e)
         {
        	 System.out.println("This is a Pattern exception");
         }
         
        /* final Scanner scr = new Scanner(System.in);
         final String regex = "^[[a-z][A-Z]][[a-z][A-Z][0-9][_]]{7,29}";
         int n = scr.nextInt();
         scr.nextLine();
         while(n-- > 0)
         {
        	 String line = scr.nextLine();
        	 System.out.println(line);
        	 
        	 if(line.matches(regex))
        	 {
        		 System.out.println("Valid");
        	 }
        	 else
        	 {
        		 System.out.println("Invalid");
        	 }
         }
         scr.close();*/
        Scanner in = new Scanner(System.in);
        in.nextLine();
 		int testCases = Integer.parseInt(in.nextLine());
 		final String ptrn = new String("<(\\w+)>([^<]+)</\\1>");
 		while(testCases>0){
 			String line = in.nextLine();
 			Pattern p2 = Pattern.compile(ptrn);
           	//Write your code here
 			Matcher m3 = p2.matcher(line);
             if(m3.find())
             {
              System.out.println(m3.group(2));
             }
             else
             {
            	 System.out.println("Pattern does not match");
             }
 			testCases--;
 		}
        in.close(); 
    }
}
