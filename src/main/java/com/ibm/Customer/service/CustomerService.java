package com.ibm.Customer.service;

import java.util.List;

import com.ibm.Customer.model.Customer;

public interface CustomerService {
	public Customer getCustomer(String customerNumber);
	public List<Customer> getCustomers();
	public Customer addCustomer(Customer customer);

}
