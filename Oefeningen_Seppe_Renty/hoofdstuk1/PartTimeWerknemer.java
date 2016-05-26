public class PartTimeWerknemer extends Werknemer

	{
		public int urenGewerkt;
		public PartTimeWerknemer(String voornaam, String achternaam, int nr, float sal, int urengw)
		{
			super(voornaam, achternaam, nr, sal);  		//verplicht op de eerste regel
			this.urenGewerkt = urengw;
		}

		public float geWeekloon()
		{
			return salaris*urenGewerkt; 				//uurloon . aantal uren gewerkt
		}

		public void salarisVerhogen(float percentage)
		{
				if(percentage > 5.0f)
				{
					System.out.println("Het percentage was te groot");
				}
				else
				{
					super.salarisVerhogen(percentage);
				}
		}
	}	