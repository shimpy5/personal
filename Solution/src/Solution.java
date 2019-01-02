import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    public static boolean canWinUtil(int index, int leap, int[] game)
    {
        boolean retVal = false;
        if(index >= game.length)
        {
            retVal = true;
        }
        else if(index < 0 || game[index] == 1)
        {
           //System.out.printf(" Hello1 game[index] is 1 at %d", index);
           //System.out.println();
           retVal = false;
        }
        else 
        {
             retVal = (canWinUtil(index+leap, leap, game) || canWinUtil(index + 1, leap, game)
            		  || canWinUtil(index-1, leap , game)) ;
        }
        return retVal;
    }
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
      return canWinUtil(0, leap, game);
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("C:\\Users\\guptas40\\Desktop\\Document.txt"));
        int q = scan.nextInt();
        //int index = 0;
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            //System.out.printf("\n Test Case number is %d \n", ++index);
            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

