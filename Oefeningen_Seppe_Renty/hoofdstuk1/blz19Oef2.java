import java.lang.*;
	
	/**
	 *	@author seppe renty
	 *	
	 *	
	 */

public class blz19Oef2 {
	public static void main(String args[])
	{
		
		
		drukaf();
		
	
	}

	public static void drukaf()
	{	
		int dag1 = 0;
		int weekdag = 0;
		
		for(int dag=1;dag<28;dag++)
		{
			dag1++;
			if(dag1==1) print("zondag "+dag+" februari");
			if(dag1==2) print("maandag "+dag+" februari");
			if(dag1==3) print("dinsdag "+dag+" februari");
			if(dag1==4) print("woensdag "+dag+" februari");
			if(dag1==5) print("donderdag "+dag+" februari");
			if(dag1==6) print("vrijdag "+dag+" februari");
			if(dag1==7) print("zaterdag "+dag+" februari");
				
			if(dag1 > 6)
			{
				dag1=0;
			}
		}
	
	}


	public static void print(String toPrint)
	{
		System.out.println(toPrint);
	}

}


	
