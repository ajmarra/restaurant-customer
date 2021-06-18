package com.ibm.Customer.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.Customer.model.Customer;
import com.ibm.Customer.service.CustomerService;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	// URL: http://ip-address:port/customer/customer (POST request)
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {

		customer = this.customerService.addCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customer, HttpStatus.OK);
		return responseEntity;
	}

	// URL: http://ip-address:port/customer/customer/O123 (GET request)
	@RequestMapping(value = "/customer/{customerNumber}")
	public ResponseEntity<?> getCustomer(@PathVariable(value="customerNumber") String customerNumber) {

		logger.info("Entered MenuController.getCustomer().  customerNumber=" + customerNumber);
		Customer customer = this.customerService.getCustomer(customerNumber);
		logger.debug("MenuController.getCustomer().  customer=" + customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customer, HttpStatus.OK);
		return responseEntity;
   }
   
   // URL: http://ip-address:port/customer/customeritems (GET request)
   @RequestMapping(value = "/customers")
   public ResponseEntity<?> getCustomers() {
	   
	   List<Customer> customers = this.customerService.getCustomers();
	   ResponseEntity<List<Customer>> responseEntity = new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	   return responseEntity;
   }
}
