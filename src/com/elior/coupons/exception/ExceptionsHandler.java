package com.elior.coupons.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.elior.coupons.beans.ErrorBean;
import com.elior.coupons.enums.ErrorType;
import com.elior.coupons.enums.TypeError;

@Provider
public class ExceptionsHandler extends Exception implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		
		int errorCode;
		String errorMassage = null;
		
		if(exception instanceof ApplicationException){
		
			ApplicationException  e  = (ApplicationException) exception ;
			errorCode = e.getErrorType().getInternalErrorCode();
			errorMassage = e.getMessage();
			ErrorBean errorBean = new ErrorBean(errorCode , errorMassage) ;
			
		
		
		return Response.status(700).entity(errorBean).build();
		}

	return Response.status(500).entity("general failure").build();
	}
	
}
