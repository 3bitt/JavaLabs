package daoRepo;

import java.util.List;

import dao.DAOFactory;
import interfejs.CompDAOInterf;
import interfejs.DAOInterf;
import interfejs.OrderDAOInterf;
import model.Company;
import model.Order;

public class CompanyRepo implements DAOInterf {
	
	
	DAOFactory database;
	CompDAOInterf CompanyDAO;
	OrderDAOInterf OrderDAO;
	
	
	
	public void refreshDB(DAOFactory factory) {
		this.database = factory;
		this.CompanyDAO = database.getCDAO();
		this.OrderDAO = database.getODAO();	
	}
	
	

	@Override
	public List<model.Company> getCompanies() {
		return this.CompanyDAO.getAllCompanies();
	}
	@Override
	public List<model.Order> getAllOrders() {
		return this.OrderDAO.getAllOrders();
	}
	
	@Override
	public List<model.Order> getSpecOrders(int companyID) {
		return OrderDAO.getSpecOrders(companyID);
	}

	
	@Override
	public void insertObject(Object object) {		
		
		System.out.println(object);
			
		if (object instanceof model.Company) {
			Company company = (Company) object;
			this.CompanyDAO.createCompany(company);
			
			System.out.println("repo company");
			
		} else if (object instanceof model.Order) {		
			Order order = (Order) object;		
			this.OrderDAO.createOrder(order);
			
			System.out.println("repo order");
		}			
	}

	@Override
	public void updateObject(Object object) {
		if (object instanceof model.Company) {
			Company company = (Company) object;
			this.CompanyDAO.updateCompany(company);
			
		} else if (object instanceof model.Order) {
			Order order = (Order) object;
			this.OrderDAO.updateOrder(order);
		}
	}
	
	@Override
	public void deleteObject(Object object) {
		
		if (object instanceof model.Company) {
			Company company = (Company) object;
			int id = company.getID();
			this.CompanyDAO.deleteCompany(id);
			
		} else if (object instanceof model.Order) {
			Order order = (Order) object;
			int id = order.getId();
			this.OrderDAO.deleteOrder(id);;
		} else if (object instanceof Integer) {
			System.out.println("INTEGER");
			
		}
		
	}

	@Override
	public void deleteCompany(int id) {
		CompanyDAO.deleteCompany(id);
	}
	
	@Override
	public void deleteOrder(int id) {
		OrderDAO.deleteOrder(id);
		
	}
	
	
	@Override
	public void createTableCompany() {
		CompanyDAO.createTableCompany();
	}
	
	public void createTableOrder() {
		OrderDAO.createTableOrder();
	}



	



	



	





}
