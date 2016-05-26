public class StudentWerknemer extends PartTimeWerknemer
{
	public StudentWerknemer(String voornaam, String achternaam, int nummer, float salaris, int urenGw)
	{
		super(voornaam, achternaam, nummer, salaris, urenGw);
		setRSZ(5f);
	}
}