package br.com.brasilprev.customer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilprev.customer.entity.Customer;
import br.com.brasilprev.customer.service.CustomerService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@Api(value = "Allows to perform operations on Customer")
@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	@GetMapping
	public List<Customer> findAllCustomers() {
		return customerService.findAllCustomers();
	}
	
	@GetMapping("/{id}")
	public Customer findAllCustomers(@PathVariable("id") final Integer id) {
		return customerService.findCustomerById(id);
	}
 
	@PostMapping
	public void save(@RequestBody final Customer customer) {
		customerService.save(customer);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") final Integer id, @RequestBody final Customer customer) {
		customerService.update(id, customer);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") final Integer id) {
		customerService.deleteById(id);
	}
	
}
