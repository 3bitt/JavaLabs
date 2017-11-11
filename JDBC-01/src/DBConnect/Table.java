package DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Table extends DBConnect {
	
	// Shows what's in Student table
	public static void show() {
		System.out.println("\t************ STUDENT ************\n");
		
		String query = "Select * from Student";
		
		// Querying thru' database  (!SQL Injection!)
		try(Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery(query)){
			
			System.out.format("%1s%15s%18s%12s",
					"ID",
					"IMIE",
					"NAZWISKO",
					"INDEKS\n\n");
			
			// Found something in table ??   Print it on screen!
			while (result.next()) {
				
				System.out.format("%1d%15s%18s%12d\n",
						result.getInt("id"),
						result.getString("imie"),
						result.getString("nazwisko"),
						result.getInt("indeks"));
			}
			System.out.println("_________________________________________________");
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}		
	}
	
	public static void add() {
		
		// Reading new Student's data
		System.out.println("\n[ Nowy Student ]");		
		System.out.println("\nImie: ");
		String name = sc.next();
		System.out.println("Nazwisko: ");
		String surname = sc.next();
		System.out.println("Numer indeksu: ");
		int indeks = sc.nextInt();
		
		String sql = "INSERT INTO Student(imie,nazwisko,indeks) VALUES(?,?,?)";
		
		// Inserting input into SQL query
		try (PreparedStatement stat = conn.prepareStatement(sql)){
			
			stat.setString(1, name);
			stat.setString(2, surname);
			stat.setInt(3, indeks);
			// Update
			stat.executeUpdate();
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		System.out.println("\n***[INFO] Dodano nowego studenta do bazy");
	}
	
	public static void edit() {					
		System.out.println("Podaj numer ID studenta lub [0] by wrócić: ");
		int id = sc.nextInt();
		
		if (id != 0) {		
		
		// Finding Student with ID
		String query = "SELECT * FROM Student WHERE ID = ?";
		
		
		//while (editOption != 4) {
			try(PreparedStatement stat = conn.prepareStatement(query)){
				stat.setInt(1, id);
				ResultSet result = stat.executeQuery();
			
				// Info about Student to be edited
				while (result.next()) {
					System.out.format("%n%-15s%n", result.getInt("id")); 
					System.out.format("%-15s%17s%n", result.getString("imie"), "[1] ---> Zmień imie");
					System.out.format("%-15s%17s%n", result.getString("nazwisko"), "[2] ---> Zmien nazwisko");
					System.out.format("%-15s%17s%n", result.getInt("indeks"), "[3] ---> Zmien numer indeksu");
					System.out.format("%-15s%17s%n", " ", "[4] ----> Wróć");
				}
				// Choose option what to change
				int editOption = sc.nextInt();
				
				if (editOption == 1) {
					System.out.println("Nowe imie: ");
					String name = sc.next();
					
					String sql = "UPDATE Student SET imie = ? WHERE id = ?";
					
					try (PreparedStatement statName = conn.prepareStatement(sql)){
						statName.setString(1, name);
						statName.setInt(2, id);
						statName.executeUpdate();					
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("*** [INFO] Zaktualizowano imie");
										
				}
				
				if (editOption == 2) {
					System.out.println("Nowe nazwisko: ");
					String surname = sc.next();
					
					String sql = "UPDATE Student SET nazwisko = ? WHERE id = ? ";
					
					try (PreparedStatement statSurname = conn.prepareStatement(sql)){
						statSurname.setString(1, surname);
						statSurname.setInt(2, id);
						statSurname.executeUpdate();					
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("*** [INFO] Zaktualizowano nazwisko");
				}
				
				if (editOption == 3) {
					System.out.println("Nowy numer indeksu: ");
					int number = sc.nextInt();
					
					String sql = "UPDATE Student SET indeks = ? WHERE id = ?";
					
					try (PreparedStatement statNumber = conn.prepareStatement(sql)){
						statNumber.setInt(1, number);
						statNumber.setInt(2, id);
						statNumber.executeUpdate();					
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("*** [INFO] Zaktualizowano numer indeksu");
				}
				
				if (editOption == 4) {
					// do nothing
				}				
			} catch (SQLException e) {
				System.out.print(e.getMessage());
			} 
		}			
	}
	
		
	public static void delete() {
		System.out.println("\n!!!! Sprawdź numery ID w tabeli !!!!"
				+ "\nWprowadź numer ID który chcesz usunąć lub [0] by wrócić");
		int deleteOption = sc.nextInt();
		
		if (deleteOption != 0) {
			
			String sql = "DELETE FROM Student WHERE id = ?";
			
			try (PreparedStatement stat = conn.prepareStatement(sql)){
				stat.setInt(1, deleteOption);
				stat.executeUpdate();
				System.out.format("*** [INFO] Usunięto rekord o numerze ID = %d", deleteOption);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
							
		} else {
			
		}		
	}
}















