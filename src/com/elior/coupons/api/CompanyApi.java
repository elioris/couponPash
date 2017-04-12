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

import com.elior.coupons.beans.Company;
import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.logic.LogicCompany;
 
@Path("/company")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class CompanyApi {
	
	LogicCompany company = new LogicCompany();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCompany(Company Company) throws ApplicationException{
	
		company.createCompny(Company);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCompany(Company Company) throws ApplicationException{
		
		company.updateCompany(Company);
	}
	
	@GET
	@Path("/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Company getCompany(@PathParam ("companyId") long id) throws ApplicationException{
		
		 return company.getCompany(id);
	}
	
	@DELETE		
	@Path("/{id}")
	public void removeCompany(@PathParam ("id") long id) throws ApplicationException{
		
		company.removeCompany(id);
		
	}
	
	
	
}
