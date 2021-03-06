package daoRepo;

import java.util.List;

import dao.DAOFactory;
import interfejs.CompDAOInterf;
import interfejs.DAOInterf;
import interfejs.OrderDAOInterf;
import model.Company;
import model.Model;
import model.Order;

public class Repository implements DAOInterf {
	
	
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
	
	/*
	 * insertObject and updateObject could be implemented in better way. This is not final version.
	 * Consider changes. 
	 */
	
	@Override
	public void insertObject(Model model) {		
					
		if (model instanceof Company) {
			Company company = (Company) model;
			this.CompanyDAO.createCompany(company);
			
		} else if (model instanceof Order) {		
			Order order = (Order) model;		
			this.OrderDAO.createOrder(order);
		}			
	}

	@Override
	public void updateObject(Model model) {
		if (model instanceof Company) {
			Company company = (Company) model;
			this.CompanyDAO.updateCompany(company);	
			
		} else if (model instanceof Order) {
			Order order = (Order) model;
			this.OrderDAO.updateOrder(order);
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
	
	
	
	
	 //TODO Not implemented methods 
	
	@Override
	public void createTableCompany() {
		CompanyDAO.createTableCompany();
	}
	
	public void createTableOrder() {
		OrderDAO.createTableOrder();
	}



	



	



	





}
