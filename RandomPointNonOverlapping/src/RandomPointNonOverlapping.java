import java.util.LinkedHashSet;
import java.util.Random;

public class RandomPointNonOverlapping {
    private Random numGen =  new Random();
    private int[][] m_rects;
    private int m_numOfRects;
    private static int numPicks = 0;
    public RandomPointNonOverlapping(int[][] rects) {
        int index = 0;
        m_rects = new int[rects.length][];
        while(index < rects.length && rects[index].length > 0)
        {
           // m_rects[index] = new int[rects[index].length];
            m_rects[index] = rects[index];
            index++;
        }
        m_numOfRects = index;
       // System.out.printf("Number of rects %d", m_numOfRects);
    }
    
    public void pick() {
    	int n = 10000;
    	while(n-- > 0)
    	{
	        int pickRecIndex = numGen.nextInt(m_numOfRects);
	        //numPicks++;
	       // System.out.printf("\nNumber of picks %d\n", numPicks);
	       // System.out.printf("\nRect picked is %d\n", pickRecIndex);
	       /* while(m_rects[pickRecIndex] == null  || m_rects[pickRecIndex].length == 0)
	        {
	            pickRecIndex = numGen.nextInt(m_rects.length);
	        }*/
	        int x1 = m_rects[pickRecIndex][0];
	        int y1 = m_rects[pickRecIndex][1];
	        int x2 = m_rects[pickRecIndex][2];
	        int y2 = m_rects[pickRecIndex][3];
	        int diffSignX = (x2 - x1) >= 0 ? 1:-1;
	        int diffSignY = (y2 - y1) >= 0 ? 1:-1;
	        if(diffSignX < 0)
	        {
	            System.out.printf("\nThe rect with negative x2-x1 is %d %d %d %d",x1, y1, x2, y2);
	        }
	         if(diffSignY < 0)
	        {
	            System.out.printf("\nThe rect with negative x2-x1 is %d %d %d %d",x1, y1, x2, y2);
	        }
	        int xMaxR = Math.abs(m_rects[pickRecIndex][2] - m_rects[pickRecIndex][0]);
	        int yMaxR = Math.abs(m_rects[pickRecIndex][3] - m_rects[pickRecIndex][1]);
	        int xR = x1 + numGen.nextInt(xMaxR+1) * diffSignX;
	        int yR = y1 + numGen.nextInt(yMaxR+1) * diffSignY;
	        int [] randomPoint = new int[2];
	        randomPoint[0] = xR;
	        randomPoint[1] = yR;
	        System.out.printf("\n[%d,%d],", randomPoint[0], randomPoint[1]);
    	}
    }
    public static void main(String args[])
    {
    	int [][]rects = { {82918473, -57180867, 82918476, -57180863},
    			{83793579, 18088559, 83793580, 18088560},
    			{66574245, 26243152, 66574246, 26243153},
    			{72983930, 11921716, 72983934, 11921720 }
    			
    	};
    	RandomPointNonOverlapping pt = new RandomPointNonOverlapping(rects);
    	pt.pick();
    }

}
