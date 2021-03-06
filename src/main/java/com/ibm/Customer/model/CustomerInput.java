package com.ibm.Customer.model;

public class CustomerInput {
	private String customerNumber, firstName, lastName, email;
	
	public CustomerInput() {
		super();
	}
	public CustomerInput (String customerNumber, String firstName, String lastName, String email) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
