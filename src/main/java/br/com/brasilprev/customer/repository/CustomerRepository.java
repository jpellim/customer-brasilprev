package br.com.brasilprev.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brasilprev.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>  {

	Customer findByName(String name);
}
