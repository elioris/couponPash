package com.elior.coupons.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.elior.coupons.beans.Customer;
import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.logic.LogicCustomer;


@Path("/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerApi {
	
	LogicCustomer customer = new LogicCustomer();
	
	@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	public void createCustomer(Customer newCustomer) throws ApplicationException{
		
		customer.createCustomer(newCustomer);
		
	}
	
	@PUT
	//@Consumes(MediaType.APPLICATION_JSON)
	public void updateCustomer (Customer updateCustomer) throws ApplicationException {
		
		customer.updateCustomer(updateCustomer);
		
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteCustomer (@PathParam ("id") long id) throws ApplicationException {
		
		customer.removeCustomer(id);
		
	}
	
	@GET
	@Path("/{id}")
	public Customer getCustomer(@PathParam ("id") long id) throws ApplicationException{
		
		return customer.getCustomer(id);
		
	}
	
	
	
}
