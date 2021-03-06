package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interfejs.CompDAOInterf;
import interfejs.OrderDAOInterf;
import model.Company;
import model.Order;

public class MysqlCompanyDAO implements CompDAOInterf, OrderDAOInterf {

	

	private static final String CREATE_COMPANY = 
			"INSERT INTO company(`name`, `street`, `number`, `postal`, `city`)  VALUES (?,?,?,?,?)";
    private static final String READ_COMPANY = 
    		"SELECT id, name, street, number, city, postal FROM company WHERE id = ?";
    private static final String READALL_COMPANY = 
    		"SELECT id, name, street, number, city, postal FROM company";
    private static final String UPDATE_COMPANY = 
    		"UPDATE company SET name=?, street=?, number=?, city=?, postal=? WHERE id = ?";
    private static final String DELETE_COMAPNY = 
    		"DELETE FROM company WHERE id = ?";
	/*private static final String CREATE_TABLE_COMPANY = "CREATE TABLE public.\"Company\"\r\n" + 
			"(\r\n" + 
			"  id SERIAL PRIMARY KEY,\r\n" + 
			"  name varchar(50),\r\n" + 
			"  street varchar(50),\r\n" + 
			"  \"number\" integer,\r\n" + 
			"  city varchar(50),\r\n" + 
			"  postal varchar(50)\r\n" + 
			")\r\n" + 
			"WITH (\r\n" + 
			"  OIDS=FALSE\r\n" + 
			");\r\n" + 
			"ALTER TABLE public.\"Company\"\r\n" + 
			"  OWNER TO postgres;\r\n" + 
			"GRANT ALL ON TABLE public.\"Company\" TO postgres;\r\n" + 
			"GRANT ALL ON TABLE public.\"Company\" TO public;";
	*/

	private static final String CREATE_ORDER = 
			"INSERT INTO `ord`(companyID, description, quantity, price) VALUES (?,?,?,?);";
	private static final String GET_SPEC_ORDERS = 
    		"SELECT id, companyid, description, quantity, price FROM `ord` WHERE companyID = ?";	
    private static final String GET_ORDERS = 
    		"SELECT id, companyid, description, quantity, price FROM `ord`";
    private static final String UPDATE_ORDER = 
    		"UPDATE `ord` SET description=?, quantity=?, price=? WHERE id=?";
    private static final String DELETE_ORDER = 
    		"DELETE FROM `ord` WHERE id = ?";
	private static final String CREATE_TABLE_ORDER =
					"CREATE TABLE `ord`(   \r\n" + 
					"					id          INTEGER     null,  \r\n" + 
					"				    companyID   INTEGER     NOT NULL, \r\n" + 
					"				    description VARCHAR (50) NOT NULL, \r\n" + 
					"				    quantity    INTEGER     NOT NULL, \r\n" + 
					"				    price       FLOAT      NOT NULL);" 				        
			;
			
			
			
	
			//"CREATE TABLE Company(id INTEGER PRIMARY KEY AUTOINCREMENT,name CHAR(50), street CHAR(50), number INT, postal INT, city CHAR(50)";
 
	public void createCompany(Company company) {
		System.out.println("mysql company create method");
		Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            con = MysqlDAO.Connect();
            System.out.println("MYSQL CONNECT SUCCESS");
            preparedStatement = con.prepareStatement(CREATE_COMPANY,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getStreet());
            preparedStatement.setInt(3, company.getNumber());
            preparedStatement.setString(4, company.getCity());
            preparedStatement.setString(5, company.getPostal());
            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();
            System.out.println("nowy rekord");
 
            if (result.next() && result != null) {
               // return result.getInt(1);
            } else {
               // return -1;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
            	System.out.println(rse);
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
            	System.out.println(sse);
            }
            try {
                con.close();
            } catch (Exception cse) {
            	System.out.println(cse);
            }
        }
        
       // return -1;
	}
	
	
	public Company getCompany(int id) {
		Company company = null;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	con = MysqlDAO.Connect();
            preparedStatement = con.prepareStatement(READ_COMPANY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {
            	company = new Company(result.getInt(1), 
            						result.getString(2), 
            						result.getString(3), 
            						result.getInt(4), 
            						result.getString(5),
            						result.getString(6));
            } else {
                // TODO
            	System.out.println("Brak klienta o ID = "+ id);
            }
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
            	System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
            	System.out.println(sse.getMessage());
            }
            try {
                con.close();
            } catch (Exception cse) {
            	System.out.println(cse.getMessage());
            }
        }
        return company;
	}
	
	
	public List<Company> getAllCompanies() {
		List<Company> companyList = new ArrayList<Company>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	conn = MysqlDAO.Connect();
            preparedStatement = conn.prepareStatement(READALL_COMPANY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            
            if (result != null){
            while(result.next())
            	companyList.add(
            					new Company(            							
            							result.getInt(1), 
            							result.getString(2), 
            							result.getString(3), 
            							result.getInt(4), 
            							result.getString(5),
            							result.getString(6)
            							));
            
            } else {
                // TODO
            	System.out.println("Brak firm");
            }
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
            	System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
            	System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
            	System.out.println(cse.getMessage());
            }
        }
        return companyList;
	}	
	

	
	public void createTableCompany() {
	}
	
		
		/*
		Connection conn = null;
		Statement stmt = null;
		try {
	    	conn = MysqlDAO.Connect();
	    	stmt = conn.createStatement();
	    	stmt.executeUpdate(CREATE_TABLE_COMPANY);
		} catch (SQLException e) {
	    	System.out.println(e.getMessage());
		} finally {
	    	try {
	    		stmt.close();
	    	} catch (Exception sse) {
	    		System.out.println(sse.getMessage());
	    	}
	    	try {
	    		conn.close();
	        } catch (Exception cse) {
	        	System.out.println(cse.getMessage());
	        }
		}
	}

*/

	@Override
	public int updateCompany(Company company) {
		Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = SqliteDAO.Connect();
            preparedStatement = con.prepareStatement(UPDATE_COMPANY);
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getStreet());
            preparedStatement.setInt(3, company.getNumber());
            preparedStatement.setString(4, company.getPostal());
            preparedStatement.setString(5, company.getCity());
            preparedStatement.setInt(6, company.getID());
            preparedStatement.execute();
            System.out.println("firma zaktualizowana");
            
            /*
            if (result.next() && result != null) {
                return result.getInt(1);
            } else {
                return -1;
            }
            */
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
        	/*
            try {
                result.close();
            } catch (Exception rse) {
            	System.out.println(rse);
            }
            */
            try {
                preparedStatement.close();
            } catch (Exception sse) {
            	System.out.println(sse);
            }
            try {
                con.close();
            } catch (Exception cse) {
            	System.out.println(cse);
            }
        }
        return -1;
	
	}
	

	public void deleteCompany(int id) {
		Connection conn = null;
	    PreparedStatement preparedStatement = null;
	    try {
	    	conn = MysqlDAO.Connect();
	    	preparedStatement = conn.prepareStatement(DELETE_COMAPNY);
	    	preparedStatement.setInt(1, id);
	    	preparedStatement.execute();
	    	
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());
	    } finally {
	    	try {
	    		preparedStatement.close();
	    	} catch (Exception sse) {
	    		System.out.println(sse.getMessage());
	    	}
	    	try {
	    		conn.close();
	        } catch (Exception cse) {
	        	System.out.println(cse.getMessage());
	        }
	    }
	   
	}

	
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ O R D E R @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	
	public int createOrder(Order order) {
		Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	System.out.println("createOrder()");
            con = MysqlDAO.Connect();
            
            preparedStatement = con.prepareStatement(CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, order.getCompanyID());
            preparedStatement.setString(2, order.getDescription());
            preparedStatement.setInt(3, order.getQuantity());
            preparedStatement.setFloat(4, order.getPrice());
            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();
            
            System.out.println("nowe zamówienie");
 
            if (result.next() && result != null) {
                return result.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
            	System.out.println(rse);
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
            	System.out.println(sse);
            }
            try {
                con.close();
            } catch (Exception cse) {
            	System.out.println(cse);
            }
        }
        return -1;
	}
	
	/*
	public Order getOrder(int id) {

		Order order = null;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	con = SqliteDAO.Connect();
            preparedStatement = con.prepareStatement(GET_SPEC_ORDERS);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {
            	order = new Order(result.getInt(1), 
            						result.getString(2), 
            						result.getInt(3), 
            						result.getInt(4));
            } else {
                // TODO
            	System.out.println("Brak zamówienia o ID = "+ id);
            }
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
            	System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
            	System.out.println(sse.getMessage());
            }
            try {
                con.close();
            } catch (Exception cse) {
            	System.out.println(cse.getMessage());
            }
        }
        return order;
	}
	
	*/
	public List<Order> getSpecOrders(int companyID) {
		List<Order> orderList = new ArrayList<Order>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	conn = MysqlDAO.Connect();
            preparedStatement = conn.prepareStatement(GET_SPEC_ORDERS);
            preparedStatement.setInt(1, companyID);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            
            if (result != null){
            while(result.next())
            	orderList.add(	new Order(result.getInt(1),
            							result.getInt(2),
                						result.getString(3), 
                						result.getInt(4), 
                						result.getInt(5))
            					);
            
            } else {
                // TODO
            	System.out.println("Brak zamówień");
            }
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
            	System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
            	System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
            	System.out.println(cse.getMessage());
            }
        }
        return orderList;
	}
	
	
	public List<Order> getAllOrders() {
		List<Order> orderList = new ArrayList<Order>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	conn = MysqlDAO.Connect();
            preparedStatement = conn.prepareStatement(GET_ORDERS);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            
            if (result != null){
            while(result.next())
            	orderList.add(		new Order(result.getInt(1), 
            							result.getInt(2),
                						result.getString(3), 
                						result.getInt(4), 
                						result.getFloat(5))
            							
            					);
            System.out.println("pobrałem dane z GetAllOrders PostgreSQLCompDAO");
            
            } else {
                // TODO
            	System.out.println("Brak zamówień");
            }
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
            	System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
            	System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
            	System.out.println(cse.getMessage());
            }
        }
        return orderList;
	}

	public void createTableOrder() {
		Connection conn = null;
		Statement stmt = null;
		try {
	    	conn = MysqlDAO.Connect();
	    	stmt = conn.createStatement();
	    	stmt.executeUpdate(CREATE_TABLE_ORDER);
		} catch (SQLException e) {
	    	System.out.println(e.getMessage());
		} finally {
	    	try {
	    		stmt.close();
	    	} catch (Exception sse) {
	    		System.out.println(sse.getMessage());
	    	}
	    	try {
	    		conn.close();
	        } catch (Exception cse) {
	        	System.out.println(cse.getMessage());
	        }
		}
		System.out.println("dodano tabele Order - Postgres");
	}
	

	public void deleteOrder(int id) {
		Order order = null;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	con = MysqlDAO.Connect();
            preparedStatement = con.prepareStatement(DELETE_ORDER);
            preparedStatement.setInt(1, id);
            
            preparedStatement.execute();
            System.out.println("usunięto zamówienie o ID: " + id);
           
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
            	System.out.println(sse.getMessage());
            }
            try {
                con.close();
            } catch (Exception cse) {
            	System.out.println(cse.getMessage());
            }
        }	
	}
	
	public int updateOrder(Order order) {
		Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            con = MysqlDAO.Connect();
            preparedStatement = con.prepareStatement(UPDATE_ORDER);
            preparedStatement.setString(1, order.getDescription());
            preparedStatement.setInt(2, order.getQuantity());
            preparedStatement.setFloat(3, order.getPrice());
            preparedStatement.setInt(4, order.getId());
            preparedStatement.execute();
            //result = preparedStatement.getResultSet();
            System.out.println("Zamowienie zaktualizowane");
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
        	
            try {
                preparedStatement.close();
            } catch (Exception sse) {
            	System.out.println(sse);
            }
            try {
                con.close();
            } catch (Exception cse) {
            	System.out.println(cse);
            }
        }
        return -1;
	
	}

}
