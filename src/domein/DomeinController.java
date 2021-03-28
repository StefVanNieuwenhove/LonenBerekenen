package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController
{
	private List<Loon> lonen;
	
	public DomeinController()
	{
		lonen = new ArrayList<>();
	}
	
	public void voegStudentToe(String naam, String achternaam, int leeftijd, double loon, int aantalDagen, double aantalKm)
	{
		lonen.add(new Jobstudent(naam, achternaam, leeftijd, loon, aantalDagen, aantalKm));
	}
	
	public void voegBediendeToe(String naam, String achternaam, int leeftijd)
	{
		lonen.add(new Bediende(naam, achternaam, leeftijd));
	}
	
	public String toonOverzicht()
	{
		String result = "";
		
		if (lonen.isEmpty())
			result += "Lijst is leeg";
		
		for (Loon l : lonen)
			result += String.format("%s", l);
		
		return result;
	}
}
