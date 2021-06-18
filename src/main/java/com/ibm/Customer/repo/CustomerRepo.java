package com.ibm.Customer.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.Customer.model.Customer;


@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long> 
{
	public Customer findByCustomerNumber(String customerNumber);
}
