import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;



public class TwoDMaxSum {
	
	int max(int a , int b)
	{
		if ( a < b)
			return b;
		return a;
	}
	
	int maxSumDP(int matrix[][], int rows , int cols)
	{
		int maxSum[][] = new int[rows][cols];
		for (int i = 0 ; i < rows; i++)
		{
			for( int j = 0; j < cols; j++)
			{
				maxSum[i][j] = 0;
			}
		}
		for (int i = 0 ; i < rows; i++)
		{
			for( int j = 0; j < cols; j++)
			{
				if (i == 0 && j == 0)
				{
					maxSum[i][j] = matrix[0][0];
				}
				if ( i == 0 && j > 0)
				{
					maxSum[i][j] = maxSum[i][j-1] + matrix[i][j];
				}
				if(i > 0 && j ==0)
				{
					maxSum[i][j] = maxSum[i-1][j] + matrix[i][j];
				}
				
				if( i > 0 && j > 0)
				{
				 maxSum[i][j] = max((maxSum[i-1][j] + matrix[i][j]), (maxSum[i][j-1] + matrix[i][j]));
				}
			}
				
		}
		
		return maxSum[rows-1][cols-1];
	}
	
	void swap (int a, int b)
	{
		int temp = a;
		a = b;
		b = temp;
	}
	class Node
	{
		private int data;
		private Node left;
		private Node right;
		
		Node()
		{
			data = 5;
			left = null;
			right = null;
		}
		void setData()
		{
			data = 6;
		}
		int getData()
		{
			return data;
		}
		void print()
		{
	      System.out.println(data);
	      System.out.println(left);
	      System.out.println(right);
		}
	}
	void buildListAndIterate()
	{
		Node n1 = new Node();
		Node n2 = new Node();
		n2.setData();
		List<Node> mylist = new LinkedList<Node>();
	    mylist.add(n1);
	    mylist.add(n1);
	    mylist.add(n2);
	    Iterator<Node> itr = mylist.iterator();
	    while(itr.hasNext())
	    {
	    	Node elem = itr.next();
	    	elem.print();
	    	
	    }
	    ListIterator<Node> revItr = mylist.listIterator(mylist.size());
	    while(revItr.hasPrevious())
	    {
	    	revItr.previous().print();
	    	
	    }
	    ArrayList<String> arlist = new ArrayList<String>();
	    arlist.add("abc");
	    arlist.add("def");
	    ListIterator<String> revItr1 = arlist.listIterator(arlist.size());
	    while(revItr1.hasPrevious())
	    {
	    	System.out.println(revItr1.previous());
	    }
		
	}
	void buildHmapandIterate()
	{
		ArrayList<String> arrlist = new ArrayList<String>();
		arrlist.add("Gupta");
		arrlist.add("Truth");
		HashMap<String, ArrayList<String>> hmp = new HashMap<String, ArrayList<String>>();
		hmp.put("Shimpy", arrlist);
		if (hmp.containsKey("Shimpy") == true)
		{
			ArrayList<String> arrlist1 = hmp.get("Shimpy");
			arrlist1.add("Hello");
		}
		if(hmp.containsValue(arrlist) == true)
		{
			System.out.println("Truth is available as a value");
		}
		hmp.put("Kapil", null);
		
		System.out.println("----------Hashmap Values-------------");
		Collection<ArrayList<String>> clarlist = hmp.values();
		for(ArrayList<String> arl : clarlist)
		{
			if( arl != null)
			{
			for(String arStr : arl)
			{
				System.out.println(arStr);
			}
			}
		}
		System.out.println("---------------Hashmap Keys-----------");
		Set<Map.Entry<String, ArrayList<String>>> mp = hmp.entrySet();
		for (Map.Entry<String, ArrayList<String>> mpe : mp)
		{
			String str = mpe.getKey();
			System.out.println(str);
		}
		
	}
	class CompareString implements Comparator<String>
	{
      public int compare(String s1, String s2)
      {
    	  if(s1.compareToIgnoreCase(s2) == 0)
    	  {
    		  return 1;
    	  }
    	  return 0;
      }
		
	}
	void buildTreeMapAndIterate()
	{
		System.out.println("---------------TreeMap-----------");
		CompareString c1 = new CompareString();
		TreeMap<String, String> trMap = new TreeMap<String, String>(c1);
		trMap.put("Shimpy", "Gupta");
	    
		NavigableSet<String> nSet = trMap.navigableKeySet();
		for (String str : nSet)
		{
			System.out.println(str);
		}
		
	}
	/*buildSetAndIterate()
	{
		
	}*/
	public static void main(String args[])
	{
		int rows = 0;
		int cols = 0;
		System.out.println("Enter the size of matrix");
		Scanner sc = new Scanner(System.in);
		rows = sc.nextInt();
		cols = rows;
		int matrix[][] = new int[rows][cols];
		System.out.println("Enter elements row wise:");
		for(int i=0; i <rows; i++)
		{
			System.out.println("Enter row i+1");
			for(int j = 0 ; j< cols; j++)
			{
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i <rows; i++)
		{
			
			for(int j = 0 ; j< cols; j++)
			{
				System.out.print(matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		sc.close();
		TwoDMaxSum Sum2d = new TwoDMaxSum();
		int maxTotal  = Sum2d.maxSumDP(matrix, rows, cols);
		System.out.println(maxTotal);
		
		int arr[] = {1,2,3,4};
		Sum2d.swap(arr[0], arr[1]);
		for(int i=0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		Sum2d.buildListAndIterate();
		Sum2d.buildHmapandIterate();
		Sum2d.buildTreeMapAndIterate();
	}

}
