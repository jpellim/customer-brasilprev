package br.com.brasilprev.customer.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data 
public class Customer {

    @Id
    @GeneratedValue
	private Integer id;

	private String name;

	private String cpf;

	@Embedded
	private Address address;
	
	public Customer(final String name, final String cpf, final Address address) {
		this.name = name;
		this.cpf = cpf;
		this.address = address;
	}

}
