package DBConnect;


class Menu extends DBConnect{
	
	static int pointer;	

	// First Menu - database connecting
	public static int start() {		
		
		System.out.println("\n~~~~~~~~~~~ [ MENU ] ~~~~~~~~~~~ \n\n"
				+ "--->\t[1] Połącz z bazą danych\n"
				+ "--->\t[2] Koniec\n"
				+ "_____________________________\n");
		pointer = sc.nextInt();
		
		while ((pointer != 1) && (pointer != 2)) {
			System.out.println("\nWprowadz 1 lub 2");
			pointer = sc.nextInt();			
		}		
		return pointer;
	}
	
	// Function Menu
	public static int Stage1() {
		
		System.out.println("\n~~~~~~~~~~ [ MENU ] ~~~~~~~~~~\n\n"
				+ "---> [1]  Pokaż tabele\n"
				+ "---> [2]  Dodaj studenta\n"
				+ "---> [3]  Zmień dane studenta\n"
				+ "---> [4]  Usuń wpis\n"
				+ "---> [5]  Rozłącz i wyjdź\n"
				+ "__________________________________");
		pointer = sc.nextInt();
		
		// (pointer != 1 && pointer != 2 && pointer != 3 && pointer != 4 && pointer != 5)
		while (pointer < 1 && pointer > 5) {
			System.out.println("Wybierz opcje z Menu");
			pointer = sc.nextInt();			
		}			
		return pointer;
	}	
}








