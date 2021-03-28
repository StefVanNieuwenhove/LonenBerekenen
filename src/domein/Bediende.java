package domein;

public class Bediende extends Werknemer
{

	public Bediende(String naam, String achternaam, int leeftijd)
	{
		super(naam, achternaam, leeftijd);
	}

	@Override
	public double berekenLoon()
	{
		return 0;
	}

}
