package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;
import org.sqlite.SQLiteConfig;

import interfejs.CompDAOInterf;
import interfejs.OrderDAOInterf;

public class MysqlDAO extends DAOFactory{

	private static final String user = "root";
	private static final String pass = "";
	
	// dozEDAnsmCuDAuuH - baton
	private static final String DBURL = "jdbc:mysql://localhost/mydb";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	
    private static final String CHARSET = "?useUnicode=true&characterEncoding=UTF-8";

	
	public static Connection Connect() {
		Connection con = null;		
		System.out.println("MysqlDAO Connect method");
		
		try   {
            Class.forName(DRIVER);
            System.out.println("po driver");
            con = DriverManager.getConnection(DBURL + CHARSET, user, pass);
            
            
            System.out.println("Nawiązano połączenie MySQL");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
        	System.out.println(e);
        
        }
		return con;		
	}

	
	public static MysqlCompanyDAO getCompanyDAO() {
		return new MysqlCompanyDAO();		
	}
	
	@Override
	public CompDAOInterf getCDAO() {
		return new MysqlCompanyDAO();
	}


	@Override
	public OrderDAOInterf getODAO() {
		return new MysqlCompanyDAO();
	}
	
}
