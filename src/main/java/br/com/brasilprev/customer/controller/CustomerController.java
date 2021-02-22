package br.com.brasilprev.customer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(value = "Allows to perform operations on Customer")
@RestController
@RequiredArgsConstructor
@RequestMapping("/brasilprev/v1/customer")
public class CustomerController {

	private final CustomerService customerService;

	@ApiOperation("Read all customer Operation")
	@GetMapping
	public List<Customer> findAllCustomers() {
		return customerService.findAllCustomers();
	}
	
	@ApiOperation("Read customer by id Operation")
	@GetMapping("/{id}")
	public Customer findAllCustomers(@PathVariable("id") final Integer id) {
		return customerService.findCustomerById(id);
	}
 
	@ApiOperation("Save customer Operation")
	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody final Customer customer) {
		Customer customerSaved = customerService.save(customer);
		return (customerSaved != null) ? new ResponseEntity<>(customerSaved, HttpStatus.CREATED)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation("Update customer Operation")
	@PutMapping("/{id}")
	public ResponseEntity<Customer> update(@PathVariable("id") final Integer id, @RequestBody final Customer customer) {
		Customer customerSaved = customerService.update(id, customer);
		return (customerSaved != null) ? new ResponseEntity<>(customerSaved, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation("Delete customer Operation")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") final Integer id) {
		customerService.deleteById(id);
	}
	
}
