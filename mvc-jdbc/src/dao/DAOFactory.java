package dao;

import interfejs.CompDAOInterf;
import interfejs.OrderDAOInterf;

public abstract class DAOFactory {

	public static final int MYSQL = 0;
	public static final int SQLITE = 1;

	public static int activeDB = -1;

	//public static boolean valid;

	public static DAOFactory getDatabase(int db) {

		if (db == 1) {
			System.out.println("MYSQL");
			activeDB = 1;
			return new MysqlDAO();

		} else if (db == 0) {
			System.out.println("SQLITE");
			activeDB = 0;
			return new SqliteDAO();
			
		} else {
			return null;
		}

	}

	public abstract CompDAOInterf getCDAO();
	public abstract OrderDAOInterf getODAO();

}
