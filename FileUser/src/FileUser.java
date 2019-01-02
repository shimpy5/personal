import java.io.FileInputStream;
import java.io.IOException;


public class FileUser {
	
	String m_filePath = "C:\\Users\\guptas40\\Desktop\\def.txt";
	void ReadBytes()
	{
		FileInputStream m_fInputStream = null;
		try
		{
		m_fInputStream = new FileInputStream(m_filePath);
		byte[] arrB = new byte[2];
		
			int offset = 0;
			int length = arrB.length;
		 while (m_fInputStream.read(arrB, offset, length) != -1)
		 {
			System.out.printf("%b", arrB);
			offset += length;
		 }
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(m_fInputStream != null)
				{
					m_fInputStream.close();
				}
			}
			catch(IOException e)
			{
				
			}
			finally
			{
				
			}
		}
		
		
	}
	void WriteBytes()
	{
		
	}
	void ReadLine()
	{
		
	}
	void WriteLine()
	{
		
	}
	void ReadCharacter()
	{
		
	}
	void WriteCharacter()
	{
		
	}
	public static void main(String args[])
	{
		FileUser fuser = new FileUser();
		fuser.ReadBytes();
	}
    
}
