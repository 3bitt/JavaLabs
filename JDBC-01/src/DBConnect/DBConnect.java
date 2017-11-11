package DBConnect;

import java.util.Scanner;
import java.sql.*;


public class DBConnect {
	
	static Scanner sc = new Scanner(System.in);
	
	// Exit function
	static void exit() {
		
		try {			
            if (conn != null) {
                conn.close();
                System.out.println("\nPołączenie zamknięte");
                System.out.println("Koniec programu");
                System.exit(0);
            
            } else {
            	conn.close();
            	System.out.println("Zakończono");
            }
           
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        	}		
	}
	
	// Database file path
										// home/kuba/DB/test.db
	static String db = "jdbc:sqlite:";
	static String workDir = System.getProperty("user.dir");
	static String url = (db + workDir + "/Student.db");
	static Connection conn = null;
	static Connection checkResources = null;
	
	// Connecting to database
	public static void Connect() {
		
        try {
            // create a connection to the database       
        	
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(true);
            
            DatabaseMetaData info = conn.getMetaData();
            ResultSet tab = info.getTables(null, null, "%", null);
            
            // If there isn't any database in working directory - Create one
            if (tab.next() == false) {            	
            	
            	System.out.println("...Konfiguruje nową baze danych...");
            	System.out.println("...Lokalizacja bazy danych: " + workDir);            	            			
            	
            	String createTab = "CREATE TABLE Student (\n" + 
            			"    id       INTEGER PRIMARY KEY AUTOINCREMENT,\n" + 
            			"    imie     VARCHAR NOT NULL,\n" + 
            			"    nazwisko VARCHAR NOT NULL,\n" + 
            			"    indeks   INT     UNIQUE ON CONFLICT ROLLBACK\n" + 
            			");";
            	
            	PreparedStatement newTab = conn.prepareStatement(createTab);
            	newTab.executeUpdate();
            	            	
            	System.out.println("\n...Tabela [ Student ] została dodana");
            	System.out.println("...Tabela [ Student ] jest pusta, dodaj pierwszych studentów");
            	
            } else {
        	
            }            
            System.out.println("***[INFO] Połączenie z bazą zostało nawiązane\n");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        } 
	}	
	
			public static void main(String[] args) {
				
				// Start Menu
				if (Menu.start() == 1) {
					Connect();
					
					// Function Menu - navigation control
					while (Menu.Stage1() != 5) {
						
						
						if (Menu.pointer == 1) {
							Table.show();					
						} 
						
						if (Menu.pointer == 2) {
							Table.add();
						}
						
						if (Menu.pointer == 3) {
							Table.edit();							
						}
						
						if (Menu.pointer == 4) {
							Table.delete();
						}
					} 
					
					exit();
					
				} else { 
					exit(); 
			}															
		}
}

	
