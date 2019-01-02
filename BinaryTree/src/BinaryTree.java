import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class BinaryTree
{
    public class Node
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
    private Node root;
    
    public BinaryTree(char [] arr)
    {
            Node n1 = new Node(arr[0]);
            n1.left = new Node(arr[1]);
            n1.right = new Node(arr[2]);
            n1.left.left = new Node(arr[3]);
            n1.left.right = new Node(arr[4]);
            n1.left.left.left = new Node(arr[5]);
            n1.left.left.right = new Node(arr[6]);
            root = n1;
        
    }
    public void LevelByLevelTraverse()
    {
      if(root == null)
      {
          System.out.println("Tree is empty");
      }
      Queue<BinaryTree.Node>pQ = new LinkedList<BinaryTree.Node>();
      
      Node dummyNode = new Node('-');
      pQ.add(root);
      pQ.add(dummyNode);
      List<BinaryTree.Node> level = new ArrayList<BinaryTree.Node>();
      do
      {
          BinaryTree.Node n = pQ.poll();
          
          if(n.getData().equals('-'))
          {
              System.out.println();
              for(Node n1: level)
              {
                  System.out.printf("%c ", n1.getData());
              }
              pQ.add(n);
              level.clear();
          }
          else
          {
              level.add(n);
          }
          if(n.getLeft()!=null)
          {
              pQ.add(n.getLeft());
          }
          if(n.getRight() != null)
          {
              pQ.add(n.getRight());
          }
      }while(pQ.size() > 0);
        
    }
    
}
public class Solution {
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
        BinaryTree bT = new BinaryTree(arr);
        bT.LevelByLevelTraverse();
    }
}
public class BinaryTree {

}
