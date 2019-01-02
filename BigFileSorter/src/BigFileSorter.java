import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class BigFileSorter {
	
	ArrayList<Integer> arrlist;
	final int bytesHundredMB = 16;
	int start = 0;
	
	class PQNode
	{
		private DataInputStream inpStreamH;
		private Integer data;
		
		PQNode(DataInputStream dataStream, Integer dat)
		{
			inpStreamH = dataStream;
			data = dat;
		}
		DataInputStream getDataInputStream()
		{
			return inpStreamH;
		}
		Integer getData()
		{
			return data;
		}
		
	}
	class BigFileComparator implements Comparator<BigFileSorter.PQNode>
	{
		public int compare(BigFileSorter.PQNode n1,  BigFileSorter.PQNode n2)
		{
			if(n1.getData() < n2.getData())
			{
				return -1;
			}
			else if(n1.getData() == n2.getData())
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		
	}
	public int autoIncrement()
	{
		if(start < Integer.MAX_VALUE - 1)
		{
		 start++;
		}
		else
		{
			start = -1;
		}
		return start;
	}
	
	public void DivideAndSortFile(String path) throws FileNotFoundException,IOException
	{
		/*byte b = (byte)0xfe;
		
		int a1 = b;
		
		System.out.println(b);
		
		if (true)
			return;*/
		FileOutputStream fOut = new FileOutputStream(path);
		//ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		DataOutputStream dOut = new DataOutputStream(fOut);
		Random rand = new Random();
		int oneMB = 1024*1024;
		for(int y = 0 ; y < oneMB; y++)
		{
			for(long x = 0; x < 8; x++)
			{
			  int z = rand.nextInt();
			  System.out.println(z);
			  dOut.writeInt(z);
			  dOut.flush();
			}
			System.out.println();
			System.out.println();
		}
	//	int remBytes = bytes % 5;
	
		
		/*System.out.println(a);
		System.out.printf("%x\n", (byte)(a));
		System.out.printf("%x\n", (byte)(a >> 8));
		System.out.printf("%x\n", (byte)(a >> 16));
		System.out.printf("%x\n", (byte)(a >> 24));
		System.out.println();
		
		byte[] n = new byte[4];
		n[0] = (byte)a;
		System.out.printf("%2x", n[0]);
		a = a >> 8;
		n[1] = (byte)a;
		System.out.printf("%2x", n[1]);
		a = a >> 8;
		n[2] = (byte)a;
		System.out.printf("%2x", n[2]);
		a = a >> 8;
		n[3] = (byte)a;
		System.out.printf("%2x", n[3]);
		fOut.write(n);
		fOut.close();
		FileInputStream fIn = new FileInputStream(path);
		byte[] bInt = new byte[4];
		while(fIn.read(bInt, 0, 4) != -1)
		{
			ByteBuffer bb = ByteBuffer.allocate(5);
			//bb.order(ByteOrder.LITTLE_ENDIAN);
			if(ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN))
			{
				System.out.println(true);
			}
			else
			{
				System.out.println(false);	
			}
			bb.put(bInt);
			bb.flip();
			
			System.out.println("From byte buffer");
			System.out.println(bb.getInt());
			//bb.allocate(capacity);
			System.out.println();
			int x = 0;
			x = bInt[0] & 0xff;
			//x = x << 8;
			x = x | ( (bInt[1] & 0Xff) << 8) | ((bInt[2] & 0Xff) << 16) | ((bInt[3] & 0xff) << 24);
			//x = x | bInt[1];
			//x = x << 8;
			//x = x | bInt[0];
			//System.out.println("%02x", (byte) x);
			
			//x = (bInt[0] << 24 | bInt[2] << 16 | bInt[1] << 8 | bInt[0]);
			/*System.out.printf("%02x", (byte) x);
			x = x << 8;
			x |= bInt[1];
			System.out.printf("%02x", (byte) x);
			x = x << 8;
			x |= bInt[2];
			System.out.printf("%02x", (byte) x);
			x = x >> 8;
		    x |= bInt[0];
		    System.out.printf("%02x", (byte) x);*/
		  /*  System.out.println();
			System.out.println(x);
			System.out.println();
			/*System.out.printf("%02x", (byte) x);
			System.out.printf("%02x", (byte) (x >> 8));*/
			/*System.out.println();
			System.out.printf("%x", bInt[0]);
			System.out.printf("%x", bInt[1]);
			System.out.printf("%x", bInt[2]);
			System.out.printf("%x", bInt[3]);*/
		dOut.flush();
		fOut.flush();
		dOut.close();
		fOut.close();
		
		System.out.printf("Length of file is %d", new File(path).length());
		System.out.println();
		byte[] bytes = new byte[bytesHundredMB];
		int byteStart = 0;
		//int numBytes = 0;
 		FileInputStream inputStream = new FileInputStream(path);
 		DataInputStream dInputStream = new DataInputStream(inputStream);
 		
 		ArrayList<String> pathToSortedFileList = new ArrayList<>();
 		ArrayList<Integer> list = new ArrayList<>();
 		
 		while( dInputStream.available() > 0)
 		{
 			 /*byteStart += numBytes;
 			 System.out.printf("Number of bytes read %d", numBytes);
 			 System.out.println();
	 		 inputStream.read(bytes);
	 		 ByteBuffer byteBuf = ByteBuffer.wrap(bytes);
	 		 while(numBytes > 0)
	 		 {
	 		   int x = byteBuf.getInt();
	 		   list.add(x);
	 		   System.out.println(x);
	 		   numBytes -=4;
	 		 }*/
 			 int countNum = 0;
 			 while(countNum < 4)
 			 {
 				int x = dInputStream.readInt();
 				System.out.println(x);
 				list.add(x);
 				countNum++;
 			 }
	 		 System.out.println();
	 		 Collections.sort(list);
	 		 System.out.println("After Sorting");
	 		 
	 		 StringBuilder pathToSortedFile = new StringBuilder(path);
	 		 pathToSortedFile.append(String.valueOf(autoIncrement()));
	 		 pathToSortedFileList.add(pathToSortedFile.toString());
	 		 FileOutputStream fOut1 = new FileOutputStream(pathToSortedFile.toString());
	 		 DataOutputStream opStream = new DataOutputStream(fOut1);
		     for (Integer x : list)
		     {
		    	     System.out.println(x);
		        	 opStream.writeInt(x);
		     }
		     System.out.println();
		     fOut1.close();
		     opStream.close();
		     //numBytes = inputStream.read(bytes, byteStart, bytes.length);
 		}
 		inputStream.close();
 		Merge(pathToSortedFileList);
	}
	
	void Merge(ArrayList<String> pathToSortedFileList) throws IOException
	{
	 ArrayList<DataInputStream> inputStreamHandleList = new ArrayList<>();
     PriorityQueue<PQNode> pq = new PriorityQueue<>(new BigFileComparator());
     for(String pathToFile:pathToSortedFileList)
     {
    	 FileInputStream inpStream = new FileInputStream(pathToFile);
    	 DataInputStream dataInp = new DataInputStream(inpStream);
    	 pq.add(new PQNode(dataInp, dataInp.readInt()));
    	 inputStreamHandleList.add(dataInp);
     }
     
     FileOutputStream fOutStream = null;
     DataOutputStream dataOutputStream = null;
     try
     {
    	 fOutStream = new FileOutputStream("C:\\Shimpy\\sortedabc");
    	 dataOutputStream = new DataOutputStream(fOutStream);
	     while(pq.size() > 0)
	     {
	    	 PQNode dataNode = pq.poll();
	    	 dataOutputStream.writeInt(dataNode.getData());
	    	 
	    	 if(dataNode.getDataInputStream().available() >= 4)
	    	 {
	    		 pq.add(new PQNode(dataNode.getDataInputStream(), dataNode.getDataInputStream().readInt()));
	    	 }
	    	 else
	    	 {
	    		 dataNode.getDataInputStream().close();
	    	 }
	    	 
	     }
     }
     catch (Exception e)
     {
    	 e.printStackTrace();
     }
     finally
     {
    	try
    	{
	    	 if(fOutStream != null)
	    		 fOutStream.close();
	    	 if(dataOutputStream != null)
	    		 dataOutputStream.close();
    	}
    	catch (Exception e)
    	{
    		
    	}
    	finally
    	{
    	  	
    	}
     }
	} 
	
	public static void main(String args[]) throws FileNotFoundException, IOException
	{
		BigFileSorter bfs = new BigFileSorter();
		bfs.DivideAndSortFile("C:\\Shimpy\\abc");
	}

}
 