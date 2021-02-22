package br.com.brasilprev.customer.service;

import java.util.List;

import br.com.brasilprev.customer.entity.Customer;

public interface CustomerService {
	
	List<Customer> findAllCustomers();
	
	Customer findCustomerById(Integer id);
	
	Customer save(Customer customer);
	
	Customer update(Integer id, Customer customer);
	
	void deleteById(Integer id);

}
