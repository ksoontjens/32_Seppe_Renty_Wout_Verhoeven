import java.lang.*;
	
	/**
	 *	@author seppe renty
	 *	
	 *	
	 */

	public class klassenOef {
	public static void main(String args[])
	{
		drukaf();
	}

	public static void drukaf()
	{	
		
		Werknemer jan = new Werknemer("jan", "janssen", 1, 900.0f);
		Werknemer pieter = new Werknemer("pieter", "Michielsen", 2, 4500.0f);
		Werknemer johan = new Werknemer("johan", "Renty", 3, 5100.0f);
		Werknemer bert = new Werknemer("Bert", "Joris", 4, 6532.0f);
		PartTimeWerknemer adriaan = new PartTimeWerknemer("adriaan", "gert", 5, 1500.0f, 100);
		PartTimeWerknemer gertjan = new PartTimeWerknemer("Gertjan", "Andies", 6, 2500.0f, 50);
		StudentWerknemer seppe = new StudentWerknemer("seppe", "renty", 7, 3000.0f, 100);
		Faktuur factuur1 = new Faktuur(1,8522);

		adriaan.salarisVerhogen(5.0f);
		jan.salarisVerhogen(10.0f);
		pieter.salarisVerhogen(10.0f);

		adriaan.setRSZ(50f);
		jan.setRSZ(20f);
		
		print("dit is de salaris van jan: " + jan.getSalaris());
		print("Dit is de salaris van pieter: " + pieter.getSalaris());
		print("Dit is de salaris van de PartTimeWerknemer adriaan : " + adriaan.getSalaris());
		print("De rsz van adriaan is : " + adriaan.getRSZ());
		print("de rsz van jan is : " + jan.getRSZ());
		print("de rsz van seppe is : " + seppe.getRSZ());

		jan.betaal();
		adriaan.betaal();
		seppe.betaal();
		factuur1.betaal();
		
	}

	public void Betaal()
	{
		int a = 0;
	}

	public static void print(String toPrint)
	{
		System.out.println(toPrint);
	}

}


	
