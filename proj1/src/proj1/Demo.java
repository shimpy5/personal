package proj1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Demo {
	
	public void tryStringequals(String ref1, String ref2)
	{
		if ( ref1 == ref2)
			System.out.println(" Result true for ==");
		if ( ref1.equals(ref2))
			System.out.println("Result true for equals");
		else
			System.out.println("No equality Statified");
	}
	
	public void char_Int () throws IOException
	{
		FileInputStream fs = new FileInputStream("C:\\Shimpy\\eclipse\\eclipse\\notice.txt");
		byte[] byte1 = new byte[24];
		fs.read(byte1);
		
		for(int index = 0; index < byte1.length; index++)
		{
			System.out.printf("%02x\t", byte1[index]);
		}
		fs.close();
		FileReader fr = new FileReader("C:\\Shimpy\\eclipse\\eclipse\\notice.txt");
		int cfr;
		while ((cfr = fr.read()) != -1)
		{
			System.out.println(cfr);
		}
		fr.close();
	}
	
	public static void main(String args[]) throws IOException
	{
		System.out.println("Hello World");
		String ref1 = new String("Shimpy");
		String ref2 = new String("Shimpy");
		if (ref1.compareTo(ref2) == 0)
		{
			System.out.println(".Equals succeeds");
		}
			
		Demo d1 = new Demo();
		d1.tryStringequals(ref1, ref2);
		d1.char_Int();
	}

}
