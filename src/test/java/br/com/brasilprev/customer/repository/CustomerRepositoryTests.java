package br.com.brasilprev.customer.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import br.com.brasilprev.customer.entity.Address;
import br.com.brasilprev.customer.entity.Customer;

@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private CustomerRepository repository;
     
    
    @Test
    public void testSaveNewCustomer() {
    	
    	Address address = new Address("02223-010", "Rua Bla", "São Paulo", "BR");
    	
        entityManager.persist(Customer.builder().name("Jose da Silva").cpf("123.456.789-09").address(address));
                 
        Customer customer = repository.findByName("Jose da Silva");
         
        assertThat(customer.getCpf()).isEqualTo("123.456.789-09");
    }
}
