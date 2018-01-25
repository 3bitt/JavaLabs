package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import interfejs.CompDAOInterf;
import interfejs.OrderDAOInterf;

public class SqliteDAO extends DAOFactory {

	
	
	
	private static final String DBURL = "jdbc:sqlite:C:\\Kuba\\Dev-Env\\Bazy danych\\SQLite\\SQLite Studio\\bazy\\mydb.db";
	private static final String DRIVER = "org.sqlite.JDBC";
	
	
	
	public static Connection Connect() {
		Connection con = null;
		try {
			SQLiteConfig config = new SQLiteConfig();  
	        config.enforceForeignKeys(true);
            Class.forName(DRIVER);
            con = DriverManager.getConnection(DBURL, config.toProperties());
            System.out.println("Połączenie z baza - Sqlite");
            
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
        	System.out.println(e);
        }
		return con;		
	}
	
	
	public static SqliteCompanyDAO getCompanyDAO() {
		return new SqliteCompanyDAO();
		
		
	}

	@Override
	public CompDAOInterf getCDAO() {
		return new SqliteCompanyDAO();
	}

	@Override
	public OrderDAOInterf getODAO() {
		return new SqliteCompanyDAO();
	}
	
	
	
}
