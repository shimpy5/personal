import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;


public class ContentMatch {
	
   private Hashtable<String, ArrayList<String>> m_hashTable = new Hashtable<String, ArrayList<String>>();
   String generateMD5fromFile(File f)
   {
	   if( f != null)
	   {
		   FileInputStream fileStream = null;
		   try
		   {
			   fileStream = new FileInputStream(f);
			   //DataInputStream dataInpStr = new DataInputStream(new BufferedInputStream(fileStream));
			   MessageDigest md = MessageDigest.getInstance("MD5");
			   int offset;
			   byte [] b = new byte[1];
			   offset = fileStream.read(b);
			   while (offset != -1)
			   {
				   //System.out.format("%x\n", b[0]);
				  // System.out.format("%x\n", b[1]);
				   //dataInpStr.read(b);
				   md.update(b);
				   offset = fileStream.read(b);
				   //dataInpStr.
			   }
			   byte[] digest = md.digest();
			   StringBuffer hexDigest =  new StringBuffer();  
			   for ( int i =0 ; i < digest.length; i++)
			   {
				   if ((0XFF & digest[i]) < 0X10)
				   {
					   hexDigest.append("0");
				   }
				   hexDigest.append(Integer.toHexString(0xFF & digest[i]));
			   }
			   System.out.printf("\n Hex disgest is %s", hexDigest);
		       return hexDigest.toString();
		   }
		   catch(Exception e)
		   {
			e.printStackTrace();  
		   }
		   finally
		   {
			   try
			   {
			    if (fileStream != null)
				   fileStream.close();
			   }
			   catch (Exception e)
			   {
				   e.printStackTrace();
			   }
		   }
		   
	   }
	   return null;
   }
   void collectFilesWithSameContentUtil(String path)
	{
		File parentPath = new File(path);
		if( parentPath.exists())
		{
		  if(parentPath.isFile())
		  {
			 System.out.println("File Path provided");
		  }
		  else
		  {
			  for ( String fileName: parentPath.list())
			  {
				  File f = new File(parentPath, fileName);
				  
				  if(f.isDirectory())
				  {
					  System.out.printf("\n AbsolutePath Directory is %s\n", f.getAbsolutePath());
					  collectFilesWithSameContentUtil(f.getAbsolutePath());
				  }
				  else
				  {
					String key = generateMD5fromFile(f);
					 System.out.printf("\n AbsolutePath of file is %s\n", f.getAbsolutePath());
					{
					    if(m_hashTable.containsKey(key))
					    {
					    	ArrayList<String> list = m_hashTable.get(key);
					    	System.out.println("I came here");
					    	list.add(f.getAbsolutePath());
					    	m_hashTable.put(key, list);
					    }
					    else
					    {
					    	ArrayList<String> list = new ArrayList<String>();
					    	list.add(f.getAbsolutePath());
					    	m_hashTable.put(key, list);
					    }
					}
				    
				  }
			  }
		  }
			
		}
	  }
    	
	ArrayList<ArrayList<String>> collectFilesWithSameContent(String path)
	{
		collectFilesWithSameContentUtil(path);
		ArrayList<ArrayList<String>> fileSetArray = new ArrayList<ArrayList<String>>();
		
		for (Map.Entry <String, ArrayList<String>> entry : m_hashTable.entrySet())
		{
			fileSetArray.add(entry.getValue());
		}
		return fileSetArray;
	}

	public static void main(String args []) 
	{
	  System.out.println("Enter your name");
      Scanner inputSc = new Scanner(System.in);
      String name = inputSc.next();
     // while (name != null)
      //{
    	  System.out.println(name);
    	  name = inputSc.next();
    	  System.out.println(name);

      //}
      inputSc.close();
      
      try
      {
      /*File pathtoFile = new File(args[0]);
      
      System.out.println(args[0]);
      if (pathtoFile.exists())
      {
    	  //String listOfFiles [] = pathtoFile.list();
    	  
    	  for (String fileName : pathtoFile.list())
    	  {
    		  File f = new File(pathtoFile, fileName);
    		  //Path p = file.toPath();
    		  
    		  System.out.println(f.getCanonicalPath());
    		  
    		  if(f.isDirectory())
    		  {a
    			  System.out.printf("I am a Directory %s", f.getAbsolutePath());
    		  }
    	  }
      }*/
    	  ContentMatch matcher = new ContentMatch();
    	  System.out.println(args[0]);
    	  
    	  ArrayList<ArrayList<String>> outputTuples = matcher.collectFilesWithSameContent(args[0]);
    	  for (ArrayList<String> set : outputTuples)
    	  {
    		  for(String tuple : set)
    		  {
    			  System.out.printf(tuple);
    			  System.out.printf("\t");
    			 
    		  }
    		  System.out.printf("\n");
    	  }
    	  
      }
      catch (Exception e)
      {
    	  e.printStackTrace();
      }
      finally
      {
    	  
      }
     } 
}	
