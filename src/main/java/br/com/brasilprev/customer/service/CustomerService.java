package br.com.brasilprev.customer.service;

import java.util.List;

import br.com.brasilprev.customer.entity.Customer;

public interface CustomerService {
	
	List<Customer> findAllCustomers();
	
	Customer findCustomerById(Integer id);
	
	void save(Customer customer);
	
	void update(Integer id, Customer customer);
	
	void deleteById(Integer id);

}
