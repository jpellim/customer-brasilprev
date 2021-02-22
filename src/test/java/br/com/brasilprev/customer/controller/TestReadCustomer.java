package br.com.brasilprev.customer.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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

import com.google.gson.Gson;

import br.com.brasilprev.customer.CustomerApplication;
import br.com.brasilprev.customer.entity.Address;
import br.com.brasilprev.customer.entity.Customer;
import br.com.brasilprev.customer.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = { CustomerApplication.class })
public class TestReadCustomer {

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
	public void testAddEmployee() throws Exception {
 
		final Address addressStub = Address.builder().street("Rua nomeRua")
				.city("Sao Paulo").postcode("09867-309") 
				.country("BR").build();

		final Customer customerStub = Customer.builder().name("Jose da Silva").cpf("123.456.789-09").address(addressStub).build();
	 
		when(customerService.findCustomerById(1)).thenReturn(customerStub);

		Gson GSON = new Gson();

		mockMvc.perform(MockMvcRequestBuilders.get("/brasilprev/v1/customer/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(GSON.toJson(customerStub))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.cpf").value("123.456.789-09"))
				.andExpect(jsonPath("$.name").value("Jose da Silva"));

		verify(customerService).findCustomerById(1);

	}
}
