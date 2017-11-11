import java.io.*;
import java.util.Scanner;



/* Po uruchomieniu programu, wprowadź pełną scieżke do pliku tekstowego który chcesz zaszyfrować */


public class Szyfruj2 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String path;
		
		if (args.length < 1) {				// Sprawdzenie czy podano argumenty dla programu
			
			System.out.println("Podaj sciezke do pliku który chcesz zaszyfrować: ");
			
			path = sc.nextLine();			// wczytanie scieżki pliku do zaszyfrowania
									
			File encrypted = new File(path + " [Encrypted]");
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new PrintWriter(encrypted));
			
			int c;
			
			while ((c = reader.read()) != -1) {			// Szyfrowanie
				writer.write(c + 3);			
				}
			
			reader.close();								// Zamkniecie "strumieni"
			writer.close();
			
			System.out.println("\nZaszyfrowany!\nLokalizacja pliku: " + encrypted.getAbsolutePath());
			
			System.out.println("\n1. Odszyfruj plik\n2. Koniec\n");		
			
				int option = sc.nextInt();			// wczytanie wyboru	
								
				while (option != 1 && option != 2) {					
					System.out.println("\nWybierz 1 lub 2\n");
					
					option = sc.nextInt();					
					}				
					sc.close();				
					if (option == 1) {					// Odszyfrowanie
																
					File decrypted = new File(encrypted.getParentFile() + "/" + encrypted.getName().replace("[Encrypted]", "[Decrypted]"));
									
					BufferedReader decryptReader = new BufferedReader(new FileReader(encrypted.getAbsolutePath()));
					BufferedWriter decryptWriter = new BufferedWriter(new PrintWriter(decrypted));
					
					int d;
					
					while ((d = decryptReader.read()) != -1) {
						decryptWriter.write(d - 3);
						}
					decryptReader.close();
					decryptWriter.close();
					
					System.out.println("\nOdszyfrowany!\nLokalizacja pliku: " + decrypted.getAbsolutePath());	
								
					} else if (option == 2) {				// Exit
						System.out.println("Do następnego szyfrowania :)");
						System.exit(-1);						
					} else {						
						System.exit(-1);					
						}			
		} else {
			
			System.out.println("\nProgram uruchamia się bez parametrów\n");
		}
	}
}



