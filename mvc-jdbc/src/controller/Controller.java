package controller;

import java.util.List;

import dao.DAOFactory;

import daoRepo.CompanyRepo;

import model.Company;
import model.Order;
import view.View;

public class Controller {

	public static boolean active;
	public static int activeDB;
	private CompanyRepo comp;

	private View view;

	public Controller(View view, CompanyRepo model) {
		this.comp = model;
		this.view = view;
		view.setController(this);
	}

	public void connectToDB(int choice) {
		DAOFactory dao = DAOFactory.getDatabase(choice);
		Controller.activeDB = choice;
		comp.refreshDB(dao);

		refreshCompany();
		//refreshOrders();
	}

	
	
	public void insertObject(Object object) {
		if (object.getClass() == Company.class) {
			comp.insertObject((Company) object);
			refreshCompany();

		} else if (object.getClass() == Order.class) {
			comp.insertObject((Order) object);
			refreshOrders();
		}
	}
	
	
	public void updateObject(Object object) {
		if (object.getClass() == Company.class) {
			Company company;
			company = (Company) object;
			comp.updateObject(company);

		} else if (object.getClass() == Order.class) {
			Order order;
			order = (Order) object;
			comp.updateObject(order);
		}
	}
	
	
	public void deleteObject(Object object) {

		if (object.getClass() == Company.class) {

			comp.deleteObject((Company) object);
			refreshCompany();
			refreshOrders();

		} else if (object.getClass() == Order.class) {

			comp.deleteObject((Order) object);
			refreshOrders();
		}
	}
	
	

	public void deleteCompany(int id) {
		comp.deleteCompany(id);
		refreshCompany();
		refreshOrders();
	}

	
	public void deleteOrder(int id) {
		comp.deleteOrder(id);
	}
	

	public void refreshCompany() {
		List<Company> companies = comp.getCompanies();
		view.getCompanies(companies);
	}

	public void refreshOrders() {
		List<Order> orders = comp.getAllOrders();
		view.getOrders(orders);
	}

	public void getSpecOrders(int companyID) {
		List<Order> specOrders = comp.getSpecOrders(companyID);
		view.getSpecOrders(specOrders);

	}

}
