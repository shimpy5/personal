package crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class crypto {
	
	public static void main(String args[]) throws NoSuchAlgorithmException
	{
		Scanner scr = new Scanner(System.in);
		String str = scr.next();
		byte[] b = null;
		MessageDigest mdi1 = null;
		StringBuilder md256 = new StringBuilder();
		try
		{
		   mdi1 = MessageDigest.getInstance("SHA-256");
		   mdi1.update(str.getBytes());
		   b = mdi1.digest();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			scr.close();
		}
		for(int index = 0 ; index < 32; index++)
		{
			md256.append(Integer.toHexString(b[index] & 0xff));
		}
		System.out.println(md256);
	}
		
}

