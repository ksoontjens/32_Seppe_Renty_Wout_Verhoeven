import java.lang.*;
	
	/**
	 *	@author seppe renty
	 *	
	 *	
	 */

	public class blz19Oef6 {
	public static void main(String args[])
	{
		
		drukaf();
		
	}

	public static void drukaf()
	{	
		
		int[] a = {12,34,56,78,123,234,99,88};
		int low = 0;
		for(int i =0; i<a.length; i++)
		{
			
			if(low < a[i])
			{
				low = a[i];
			}
		
		}

		print("het hoogste getal vand de array is " + low);
				
	}

	public static void print(String toPrint)
	{
		System.out.println(toPrint);
	}

}


	
