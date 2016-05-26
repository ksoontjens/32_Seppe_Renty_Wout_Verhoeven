import java.lang.*;
	
	/**
	 *	@author seppe renty
	 *	
	 *	
	 */

	public class blz19Oef5{
	public static void main(String args[])
	{
		drukaf();
	}

	public static void drukaf()
	{	
		for(double y=3; y<=99; y++)
		{
			Boolean isNotPriem = false;
			
			for(double number = 2; number < y; number++)
			{
				if(y%number==0)
				{
					isNotPriem = true;
					number = y;
				}
			}

			if(!isNotPriem)
			{
				print("   " + y);
			}
				
		}

		
		
	}

	

	public static void print(String toPrint)
	{
		System.out.println(toPrint);
	}

}


	
