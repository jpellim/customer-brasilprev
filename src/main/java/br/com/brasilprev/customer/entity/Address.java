package br.com.brasilprev.customer.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor 
public class Address {

    private String postcode;
    
    private String street;
 
    private String city;
 
    private String country;
    
}
