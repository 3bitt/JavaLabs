package interfejs;

import java.util.List;

import model.Company;
import model.Order;

public interface DAOInterf {

	public List<Company> getCompanies();
	
	public List<Order> getAllOrders();
	public List<Order> getSpecOrders(int companyID);

	public void insertObject(Object object);

	public void updateObject(Object object);
	
	public void deleteObject(Object object);
	
	public void deleteOrder(int id);
	public void deleteCompany(int id);

	public void createTableCompany();
	public void createTableOrder();

}
