
public class MinMax {
	
	public void findMinMax(int array[], int numElem, int sWindowSize)
	{
		int sumMin = Integer.MAX_VALUE;
		int sumMax = Integer.MIN_VALUE;
        int sum = 0;		
		for (int index = 0 ; index < ( numElem - sWindowSize+1); index++)
		{
			for( int windowIndex = index ; windowIndex < (index + sWindowSize); windowIndex++)
			{
				sum += array[windowIndex];
			}
			if(sum < sumMin)
			{
				sumMin = sum;
			}
			if(sum > sumMax)
			{
				sumMax = sum;
			}
            sum = 0;
		}
		System.out.println(sumMin);
		System.out.println(sumMax);
		
	}
	
	public static void main(String args[])
	{
		
		int [] myarray = {-1,-2,4,5,3};
		MinMax minmaxObj = new MinMax();
		minmaxObj.findMinMax(myarray, myarray.length, 2);
		
		
	}

}
