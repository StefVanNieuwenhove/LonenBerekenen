package ui;

import java.util.Scanner;

import domein.DomeinController;
import domein.Jobstudent;

public class Applicatie
{
	Scanner scan = new Scanner(System.in);
	private final DomeinController dc;
	
	public Applicatie(DomeinController dc)
	{
		this.dc = dc;
	}
	
	public void start()
	{
		int invoer;
		
		System.out.println("Keuze menu:");
		System.out.println("1. Loon berekenen jobstudent");
		System.out.println("2. Loon berekenen bediende");
		System.out.println("3. Tonn overzicht");
		System.out.print("geef keuze: ");
		invoer = scan.nextInt();
		
		switch (invoer)
		{
		case 1: berekenLoonStudent(); break;
		case 2: berekenLoonBediende(); break;
		case 3: System.out.println(dc.toonOverzicht()); break;
		}
	}

	private void berekenLoonBediende()
	{
		// TODO Auto-generated method stub
		
	}

	private void berekenLoonStudent()
	{
		Jobstudent jobstudent;
		String naam, achternaam;
		int leeftijd, aantalDagen;
		double loon, aantalKm;
		
		System.out.println();
		System.out.print("Naam: ");
		naam = scan.next();
		System.out.print("Achternaam: ");
		achternaam = scan.next();
		System.out.print("Leeftijd: ");
		leeftijd = scan.nextInt();
		System.out.print("Aantal dagen gewerkt: ");
		aantalDagen = scan.nextInt();
		System.out.print("Loon: ");
		loon = scan.nextDouble();
		System.out.print("Aantal km met de fiets: ");
		aantalKm = scan.nextDouble();
		
		jobstudent = new Jobstudent(naam, achternaam, leeftijd, loon, aantalDagen, aantalKm);
		dc.voegStudentToe(naam, achternaam, leeftijd, loon, aantalDagen, aantalKm);
		
		System.out.printf("%s", jobstudent.toString());
		
	}
}
