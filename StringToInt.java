package itoa_atoi;

public class StringToInt {
	
	public void convert(long number, long base)
	{
		StringBuilder sbr =  new StringBuilder();
		char c = 0;
		while(number > 0)
		{
			long digit = number % base;
			number =  number / base;
			c = Character.forDigit((int)digit, (int)base);
		    /*switch ((int)base)
		    {
		    case 10:
		    case 8:
		    case 2:
		    	c  = (char) (digit + '0');
		    	break;
		    case 16:
		    	if(digit >= 10)
		    	{
		    		c = (char)((digit - 10) + 'A');
		    	}
		    	
		    }*/
		    
			sbr.append(c);
		}
		sbr.reverse();
		System.out.println(sbr.toString());
	}
	
	public class Mythread extends Thread
	{
		public void run()
		{
		   while(true)
		   {
			   System.out.println("Checking jstack");
		   }
		}
	}
	public static void main(String args[])
	{
		StringToInt itoStr = new StringToInt();
		itoStr.convert(1023, 10);
		long num = 0X0A;
		itoStr.convert(num, 16);
		System.out.println(num);
		long num2 = 012;
		System.out.println(num2);
		itoStr.convert(num, 8);
		StringToInt.Mythread thr = itoStr.new Mythread();
		thr.start();
	}

}
