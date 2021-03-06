package model;

public class Company {

	private Integer id;
	private String name;
	private String street;
	private Integer number;
	private String city;
	private String postal;
	
	
	
	
	public Company(Integer id, String name, String street, Integer number, String city, String postal) {
		this.id = id;
		this.name = name;
		this.street = street;
		this.number = number;
		this.postal = postal;
		this.city = city;
	}
	
	public Company(String name, String street, Integer number, String city, String postal) {
		this.name = name;
		this.street = street;
		this.number = number;
		this.postal = postal;
		this.city = city;
	}

	
	
	public Integer getID() {
		return this.id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	

	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}


	
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}


	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public Integer setID(int i) {
		this.id = i;
		return this.id;
		
	}
}
