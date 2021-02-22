package br.com.brasilprev.customer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.brasilprev.customer.entity.Customer;
import br.com.brasilprev.customer.exception.CustomerNotFoundException;
import br.com.brasilprev.customer.repository.CustomerRepository;
import br.com.brasilprev.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
 
	private final CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAllCustomers() { 
		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomerById(Integer id) {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void deleteById(Integer id) { 
		customerRepository.deleteById(id);
	}

	@Override
	public void update(Integer id, Customer customer) {
		Customer customerDb = customerRepository.getOne(id);
		customerDb.setName(customer.getName());
		customerDb.setCpf(customer.getCpf());
		customerDb.setAddress(customer.getAddress());
		customerRepository.save(customerDb);
	}
 
}
