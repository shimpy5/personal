import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Stack {

    int calculateHourGlassSum(int a[][], int startPosRow, int startPosCol)
    {
        int sum = 0;
        int n = 1;
        if(startPosCol + 2 < a[startPosRow].length && startPosRow + 2 < a.length)
        { 
            sum = sum+a[startPosRow + 1][startPosCol+1];
            do
            {
                for(int i = startPosCol; i <= startPosCol + 2; i++)
                {
                    sum = sum + a[startPosRow][i];
                }
                startPosRow+=2;
                n--;
            }while(n >= 0);
        }
        return sum;
    }

    int findMaxHourGlassSum(int a[][])
    {
        int sum = 0;
        int largeSum = 0;
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {
                sum = calculateHourGlassSum(a,i,j);
                if(sum > largeSum)
                {
                    largeSum = sum;
                }
            }
        }
        return largeSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        Stack mysln =  new Stack();
        mysln.findMaxHourGlassSum(arr);
        scanner.close();
    }
}
