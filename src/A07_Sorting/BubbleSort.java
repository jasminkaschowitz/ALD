package A07_Sorting;


public class BubbleSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {
		for (int i = 0; i < personen.length; i++) {
			boolean anyChange = false;
			for (int j = 0; j < personen.length -1 -i; j++) {
				if ((personen[j].compareTo(personen[j + 1]) > 0)) {
					Person helper = personen[j];
					personen[j] = personen[j + 1];
					personen[j + 1] = helper;
					anyChange = true;

				}
			}
			if (anyChange == false) { //wenn nach einer j Schleife, kein True = Vertausch mehr stattfindet aus Schleife rausgehen
				break;
			}
//-i --> Habe am Ende bereits die größten, brauche ich nicht mehr beachten
			// zuerst hinten -1, dann - 2,..
		}
	}
	
}
