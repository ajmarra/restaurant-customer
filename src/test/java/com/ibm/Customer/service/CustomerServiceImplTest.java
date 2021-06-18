package com.ibm.Customer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ibm.Customer.model.Customer;
import com.ibm.Customer.repo.CustomerRepo;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class CustomerServiceImplTest {
	@Mock
	private CustomerRepo customerRepo;
	
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@DisplayName("Test CustomerService getCustomer with valid customer number")
	@Test
	void testGetCustomerExistingCustomerNumber() {
		// Given - set the parameter values and mock the methods for this test case
		String customerNumber = "C0123";
		Customer customerMocked = new Customer("C0123", "AJ", "Marra", "aj.marra@ibm.com");
		when(customerRepo.findByCustomerNumber(customerNumber)).thenReturn(customerMocked);
		
		// When - call the method being tested and save the response
		Customer customer = customerService.getCustomer(customerNumber);
		
		// Then - check that the results are valid (and that the expected mocked methods are called)
		assertNotNull(customer, "Customer should not be null");
		assertEquals(customer, customerMocked, "Customer should be the same as" + customerMocked);
		
		verify(customerRepo).findByCustomerNumber(customerNumber);
	}
}
