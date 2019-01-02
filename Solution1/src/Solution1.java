import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class BinaryTree
{
    class Node
    {
     private char data;
     public Node left;
     public Node right;
     
     Node(char c)
     {
         data = c;
         left = null;
         right = null;
     }
     
     void setLeft(Node l)
     {
         left = l;
     }
     void setRight(Node r)
     {
         right = r;
     }
     Node getLeft()
     {
         return left;
     }
     Node getRight()
     {
         return right;
     }
     Character getData()
     {
      return data;
     }
    }
    private Node root1;
    
    public BinaryTree()
    {
    }
    public void LevelByLevelTraverse(Node root)
    {
      if(root == null)
      {
          System.out.println("Tree is empty");
      }
      Queue<BinaryTree.Node>pQ = new LinkedList<BinaryTree.Node>();
      
      pQ.add(root);
      
      do
      {
    	  int nodeCount = pQ.size();
    	  while(nodeCount > 0)
    	  {
    		  Node npQ = pQ.poll();
    		  if(npQ == null)
    		  {
    			  break;
    		  }
		      if(npQ.left != null)
		     {
			   pQ.add(npQ.left);
		     }
		     if(npQ.right != null)
		     {
			   pQ.add(npQ.right);
		     }
		     System.out.printf("%c ", npQ.getData());
		     nodeCount--;
    	   }
    	   System.out.println();
    	}while(pQ.size() > 0);
        
    }
    
}
public class Solution1 {
	
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        /*
           Print a binary tree level by level
           
                a
               / \
              b  c
             / \ /
            d  e f
            
           Output:
           a
           b c
           d e f
           
        */
        
        char arr[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        BinaryTree bT = new BinaryTree();
        BinaryTree.Node nRoot = bT.new Node(arr[0]);
        nRoot.left = bT.new Node(arr[1]);
        nRoot.right = bT.new Node(arr[2]);
        nRoot.left.left = bT.new Node(arr[3]);
        nRoot.left.right = bT.new Node(arr[4]);
        nRoot.right.left = bT.new Node(arr[5]);
        nRoot.right.right = bT.new Node(arr[6]);
        bT.LevelByLevelTraverse(nRoot);
    }
}