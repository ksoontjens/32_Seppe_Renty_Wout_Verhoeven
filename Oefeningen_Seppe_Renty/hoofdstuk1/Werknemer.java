public class Werknemer implements Betaalbaar{
		
		public String voornaam;
		public String achternaam;
		public int werknemerNummer;
		protected float salaris;
		private float RSZpercentage = 33f;
		
		public Werknemer(String initVoornaam, String initAchternaam, int initWnummer, float initSalaris)
			{
			salaris = initSalaris;
			this.voornaam = initVoornaam;
			this.achternaam = initAchternaam;
			this.werknemerNummer= initWnummer;
			}
		
		public void salarisVerhogen(float percentage)
			{
			salaris+=salaris*(percentage/100.0f);
			}
		
		public float getSalaris()
			{
				return salaris;
			}

		public void setRSZ(float rsz)
			{
				RSZpercentage = rsz;
			}

		public float getRSZ()
			{
				return RSZpercentage;
			}
		public void betaal(){

			System.out.println("Betaal het salaris van " + salaris + " aan de werknemer " + voornaam);
		
		}
}