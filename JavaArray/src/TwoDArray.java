class Myclass
{
	String m_name = null;
	Myclass(String name)
	{
		m_name = name;
	}
}


public class TwoDArray {
	int [][] twoDIntObj;
	Myclass [][] twoDMyclassObj;
	
	
	public static void main(String args[])
	{
		TwoDArray arr2d = new TwoDArray();
		arr2d.twoDIntObj = new int [3][4];
		arr2d.twoDMyclassObj = new Myclass [3][4];
		//Myclass a = new Myclass("Shimpy");
		for (int i=0 ; i < 3; i++)
		{
			//for(int j =0 ; j < 4; j++)
			{
				arr2d.twoDIntObj[i][0] = 2;
				arr2d.twoDMyclassObj[i][0] = new Myclass("Shimpy");
			}
		}
		
		for (int i=0 ; i < 3 ; i++)
		{
			for(int j =0 ; j < 4; j++)
			{
				System.out.println(arr2d.twoDIntObj[i][j]);
				System.out.println(arr2d.twoDMyclassObj[i][j]);
			}
		}
	}

}
