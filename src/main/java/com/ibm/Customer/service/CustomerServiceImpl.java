package com.ibm.Customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.Customer.model.Customer;
import com.ibm.Customer.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer getCustomer(String customerNumber) {
		logger.info("Entered CustomerServiceImpl.getCustomer().  customerNumber=" + customerNumber);
		
		Customer customer = this.customerRepo.findByCustomerNumber(customerNumber);
		
		logger.info("Leaving CustomerServiceImpl.getCustomer().  customerNumber=" + customerNumber);
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		logger.info("Entered CustomerServiceImpl.getCustomer().");
		
		List<Customer> customers = this.customerRepo.findAll();
		
		logger.info("Leaving CustomerServiceImpl.getCustomer().");
		return customers;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		logger.info("Entered CustomerServiceImpl.addCustomer() customerNumber= " + customer.getCustomerNumber());
		
		customer = this.customerRepo.insert(customer);
		
		logger.info("Leaving CustomerServiceImpl.addCustomer() customerNumber= " + customer.getCustomerNumber());
		return customer;
	}

}

