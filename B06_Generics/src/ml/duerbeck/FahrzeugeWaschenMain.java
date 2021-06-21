package ml.duerbeck;

import java.util.ArrayList;
import java.util.List;

public class FahrzeugeWaschenMain {

	public static void main(String[] args) {
		
		Waschstrasse<Pkw> waschstrassePkw = new Waschstrasse<>();
		Waschstrasse<Lkw> waschstrasseLkw = new Waschstrasse<>();
		Parkhaus<Fahrzeug> parkhausWuppertal = new Parkhaus<>();
		
		Pkw pkw1 = new Pkw("W-UP-1983", true);
		Lkw lkw1 = new Lkw("W-AL-0815", false);
		Pkw pkw2 = new Pkw("K-FO-808", false);
		Lkw lkw2 = new Lkw("B-EA-0104", true);
		
		System.out.println("Sauberkeitscheck:");
		pkw1.checkObDreckig();
		pkw2.checkObDreckig();
		lkw1.checkObDreckig();
		lkw2.checkObDreckig();
		
		System.out.println("Fahrzeuge aktuell im Parkhaus");
		parkhausWuppertal.anzeigenGeparkteFahrzeuge();
		
		System.out.println("\nWaschgang:");
		waschstrassePkw.waschen();
		waschstrasseLkw.waschen();

	}

}

class Waschstrasse<T extends Fahrzeug> {
	public List<T> dreckigeFahrzeuge;
	
	public Waschstrasse() {
		dreckigeFahrzeuge = new ArrayList<>();
	}
	
	void waschen() {
		for (int i = 0; dreckigeFahrzeuge.size() < i; i++) {
			this.dreckigeFahrzeuge.get(i).setDreckig(false);
			System.out.println(dreckigeFahrzeuge.get(i) + " ist jetzt sauber");
		}
	}
	
	void anzeigenFahrzeugeInWaschstrasse() {
		System.out.println("Fahrzeuge in der Waschstrasse:");
		for (T fahrzeug: dreckigeFahrzeuge) {
			fahrzeug.toString();
		}
	}
}

class Parkhaus <T extends Fahrzeug> {
	List<T> geparkteFahrzeuge;
	
	public Parkhaus() {
		geparkteFahrzeuge = new ArrayList<>();
	}
	
	void anzeigenGeparkteFahrzeuge() {
		System.out.println("Liste geparkter Fahrzeuge:");
		for (int i = 0; geparkteFahrzeuge.size() < i; i++) {
			System.out.println(geparkteFahrzeuge.get(i));
		}
	}
}

abstract class Fahrzeug {
//abstract Class, weil Zustand 'dreckig' waere bei einem
//Interface konstant
	private String kennzeichen;
	private boolean dreckig;
	public Waschstrasse<Fahrzeug> waschstrasse = new Waschstrasse<>();
	public Parkhaus<Fahrzeug> parkhaus = new Parkhaus<>();
		
	public Fahrzeug(String kennzeichen, boolean dreckig) {
		setKennzeichen(kennzeichen);
		setDreckig(dreckig);
	}
	
	public void einfahren (Waschstrasse<Fahrzeug> ws) {
		ws.dreckigeFahrzeuge.add(this);
		System.out.println(this + " ist in die Waschstrasse reingefahren.");
	}
	
	public void einfahren (Parkhaus<Fahrzeug> ph) {
		ph.geparkteFahrzeuge.add(this);
		System.out.println(this + " ins Parkhaus reingefahren.");
	}
	
	void ausfahren (Waschstrasse<Fahrzeug> ws, int index) {
		ws.dreckigeFahrzeuge.remove(index);
		System.out.println(this + " ist aus der Waschstrasse rausgefahren.");
	}
	
	void checkObDreckig() {
		if (this.isDreckig()) {
			System.out.println(this + " ist dreckig, muss also gewaschen werden.");
			this.einfahren(waschstrasse);
		} else if (!this.isDreckig()) {
			System.out.println(this + " ist sauber. Daher kann es schon ins Parkhaus gefahren werden.");
			this.einfahren(parkhaus);
		}
	}

	public String getKennzeichen() {
		return kennzeichen;
	}

	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	public boolean isDreckig() {
		return dreckig;
	}

	public void setDreckig(boolean dreckig) {
		this.dreckig = dreckig;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "- Fahrzeug, Kennzeichen " + getKennzeichen();
	}
	
	
}

class Pkw extends Fahrzeug {

	public Pkw(String kennzeichen, boolean dreckig) {
		super(kennzeichen, dreckig);
	}
}

class Lkw extends Fahrzeug {

	public Lkw(String kennzeichen, boolean dreckig) {
		super(kennzeichen, dreckig);
	}
	
}

