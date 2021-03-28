package domein;

public abstract class Werknemer implements Loon
{
	private String naam, achternaam;
	private int leeftijd;
	
	public Werknemer(String naam, String achternaam, int leeftijd)
	{
		setNaam(naam);
		setAchternaam(achternaam);
		setLeeftijd(leeftijd);
	}
	
	public String getNaam()
	{
		return naam;
	}

	public String getAchternaam()
	{
		return achternaam;
	}

	public int getLeeftijd()
	{
		return leeftijd;
	}

	public void setNaam(String naam)
	{
		if (naam.trim().isEmpty() || naam == null)
			throw new IllegalArgumentException("Naam kan niet leeg zijn");
		this.naam = naam;
	}

	public void setAchternaam(String achternaam)
	{
		if (achternaam.trim().isEmpty() || achternaam == null)
			throw new IllegalArgumentException("Achternaam kan niet leeg zijn");
		this.achternaam = achternaam;
	}

	public void setLeeftijd(int leeftijd)
	{
		if (leeftijd < 15)
			throw new IllegalArgumentException("Minimum leeftijd om te werken is 15j");
		this.leeftijd = leeftijd;
	}

	@Override
	public String toString()
	{
		return String.format("%s, %s %s - %d", super.getClass().getSimpleName(), naam, achternaam, leeftijd);
	}	
}
