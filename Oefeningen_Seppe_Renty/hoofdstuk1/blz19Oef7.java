import java.lang.*;
	
	/**
	 *	@author seppe renty
	 *	
	 *	
	 */

	public class blz19Oef7 {
	public static void main(String args[])
	{
		
		drukaf();
		
	}

	public static void drukaf()
	{	
		
		int[] a = {12,34,56,78,123,234,99,88};
		int b[] = new int[8];
		int low = 0;
		int index= 0;

		for(int i =0; i<b.length; i++)
		{
			low = 0;
			

			for(int y=0; y<a.length; y++)
			{
				if(low < a[y])
				{
					low = a[y];
					index = y;
					
				}
				
			}

			a[index] = 0;
			b[i] = low;
		
		}

		for(int y=0; y<b.length; y++)
		{
			print("getal: " + b[y]);
		}

		/*for(int i=0; i<a.length; i++)
		{
			print("getal a: " + a[i]);
		}	
	
		print("low is: " + low);	*/		
	}

	public static void print(String toPrint)
	{
		System.out.println(toPrint);
	}

}


	
