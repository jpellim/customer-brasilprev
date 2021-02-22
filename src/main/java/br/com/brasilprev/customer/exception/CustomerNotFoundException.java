package br.com.brasilprev.customer.exception;

public class CustomerNotFoundException extends RuntimeException {
   
	private static final long serialVersionUID = -5603340635267867026L;
	
	private final Integer id;

	public CustomerNotFoundException(final Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
