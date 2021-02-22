# customer-brasilprev

Customer CRUD project  

1) Authentication

   API: /login   
   
   Body: {"username": "admin",  "password": "password"}

   This service will return JWT Token, use this token as Authorization header for CRUD operations	

2) Customer CRUD apis

 
   POST → /brasilprev/v1/customer 
   
   This service receive customer information included in HTTP POST with JSON in the follow format, example:

	{
	    "name": "Joao da Silva",
	    "cpf": "43083487134",
	    "address": {
	        "street": "Rua Xpto",
	        "postcode": "02239-098",
	        "city": "Sao Paulo",
	        "country": "BR"
	    }
	}


   GET → /brasilprev/v1/customer/{id} 
 
   This service list a customer by id
 
 
 
   PUT -> /brasilprev/v1/customer/{id} 
   
   This service receive information to update a client by HTTP PUT with JSON in the following format, example:

	{
	    "name": "Joao da Silva",
	    "cpf": "43083487134",
	    "address": {
	        "street": "Rua Xpto",
	        "postcode": "02239-098",
	        "city": "Sao Paulo",
	        "country": "BR"
	    }
	}
 

   DELETE -> /brasilprev/v1/customer/{id}
   
   This service delete a customer by id 