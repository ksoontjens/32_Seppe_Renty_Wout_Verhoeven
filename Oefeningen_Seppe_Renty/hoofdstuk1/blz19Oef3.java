import java.lang.*;
	
	/**
	 *	@author seppe renty
	 *	
	 *	
	 */

	public class blz19Oef3 {
	public static void main(String args[])
	{
		
		drukaf();
		
	}

	public static void drukaf()
	{	
		double pi = 4;
		double getal =3;
		double factor = 1/1;
		double result;
		int counter = 0;

		for(int i = 1; i <= 10000; i++)
		{	
			if(i%2 != 0)
			{
			factor = factor - 1/getal;

			}
			else
			{
			factor = factor + 1/getal;

			}
		   
		    getal=getal+2;
		counter++;
		}
		
		result = pi*factor;
		print("this is the factor "+factor);
		print("the loop has been executed " + counter + " times");
		print("the result is "+result);
		
	}


	public static void print(String toPrint)
	{
		System.out.println(toPrint);
	}

}


	
