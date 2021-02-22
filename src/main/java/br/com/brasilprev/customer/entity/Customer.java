package br.com.brasilprev.customer.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data 
@Builder
public class Customer {

    @Id
    @GeneratedValue
	private Integer id;

	private String name;

	private String cpf;

	@Embedded
	private Address address;
	
}
