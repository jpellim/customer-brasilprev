package br.com.brasilprev.customer.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.brasilprev.customer.CustomerApplication;
import br.com.brasilprev.customer.entity.Address;
import br.com.brasilprev.customer.entity.Customer;
import br.com.brasilprev.customer.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = { CustomerApplication.class })
public class TestDeleteCustomer {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@MockBean
	CustomerService customerService;
 

	@Test
	public void testDeleteAddress() throws Exception {
 
		final Address addressStub = Address.builder().street("Rua nomeRua")
				.city("Sao Paulo").postcode("09867-309") 
				.country("BR").build();

		final Customer customerStub = Customer.builder().name("Jose da Silva").cpf("123.456.789-09").address(addressStub).build();
	 
		when(customerService.findCustomerById(1)).thenReturn(customerStub);

		mockMvc.perform(MockMvcRequestBuilders.delete("/brasilprev/v1/customer/1")
				.contentType(MediaType.APPLICATION_JSON) 
				.accept(MediaType.APPLICATION_JSON));

		verify(customerService).deleteById(1);

	}
}
