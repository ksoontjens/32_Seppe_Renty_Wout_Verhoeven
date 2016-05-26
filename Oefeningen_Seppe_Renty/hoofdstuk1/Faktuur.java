public class Faktuur implements Betaalbaar{
		
		public int faktuurNr;
		public int faktuurBedrag;
		
		
		public Faktuur(int initNr, int initBedrag)
			{
				this.faktuurNr = initNr;
				this.faktuurBedrag = initBedrag;
			}
		
		
		public void betaal(){

			System.out.println("Betaal het faktuur " + faktuurNr + " voor een bedrag van " + faktuurBedrag);
		
		}
}