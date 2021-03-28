package domein;

public class Jobstudent extends Werknemer
{	
	private int aantalDagen;
	private double loon, aantalKm;
	private static final double RSZ = 0.0271;
	private static final double FIETSVERGOEDING = 0.24;
	private static final double STANDPLAATSVERGOEDING = 52.22;
	private static final double STANDPLAATSVERGOEDING_BETALEN = 2.3;
	
	public Jobstudent(String naam, String achternaam, int leeftijd, double loon, int aantalDagen, double aantalKm)
	{
		super(naam, achternaam, leeftijd);
		setLoon(loon);
		setAantalDagen(aantalDagen);
		setAantalKm(aantalKm);
	}

	public double brutoloon()
	{
		return (aantalDagen * 7.6) * loon;
	}
	
	public double standplaatsvergoeding()
	{
		return STANDPLAATSVERGOEDING - (STANDPLAATSVERGOEDING_BETALEN * aantalDagen);
	}
	
	public double totaalBruto()
	{
		return brutoloon() + standplaatsvergoeding();
	}
	
	public double rsz()
	{
		return totaalBruto() * RSZ;
	}
	
	public double belastbaarLoon()
	{
		return totaalBruto() - rsz();
	}
	
	public double fietsvergoeding()
	{
		return aantalKm * FIETSVERGOEDING;
	}
	
	@Override
	public double berekenLoon()
	{
		return belastbaarLoon() + fietsvergoeding();
	}	
	
	public int getAantalDagen()
	{
		return aantalDagen;
	}

	public double getLoon()
	{
		return loon;
	}

	public double getAantalKm()
	{
		return aantalKm;
	}

	public void setAantalDagen(int aantalDagen)
	{
		if (aantalDagen < 1)
			throw new IllegalArgumentException("Minsten 1 dag werken");
		this.aantalDagen = aantalDagen;
	}

	public void setLoon(double loon)
	{
		if (loon < 6.8499)
			throw new IllegalArgumentException("Minimumloon student is 6,8499");
		this.loon = loon;
	}

	public void setAantalKm(double aantalKm)
	{
		if (aantalKm < 0)
			throw new IllegalArgumentException("Error aantal km");
		this.aantalKm = aantalKm;
	}

	@Override
	public String toString()
	{
		String result = "";
		result += String.format("%s%n", super.toString());
		//result += String.format("Dagen: %d%nLoon: %.4f%nBrutoloon: %.2f%nStandplaatsvergoeding: %.2f%nStandplaatsvergoeding: - %.2f%nTotaal brutoloon: %.2f%nRSZ jobstudent: %.2f%nTotaal belastbaar: %.2f%nFietsvergoeding: %.2f%nNettoloon: %.2f"
				//, aantalDagen, loon, brutoloon(), STANDPLAATSVERGOEDING, standplaatsvergoeding(), totaalBruto(), rsz(), belastbaarLoon(), fietsvergoeding(), berekenLoon());
		result += String.format("Dagen: %d%nLoon: %.4f%n%.2f Brutoloon"
				, aantalDagen, loon, brutoloon(), STANDPLAATSVERGOEDING, standplaatsvergoeding(), totaalBruto(), rsz(), belastbaarLoon(), fietsvergoeding(), berekenLoon());
		return result;
	}
}
