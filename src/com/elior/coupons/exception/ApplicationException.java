package com.elior.coupons.exception;

import java.sql.SQLException;

import com.elior.coupons.enums.ErrorType;
import com.elior.coupons.enums.TypeError;

public class ApplicationException extends Exception{
	
	private TypeError errorType;
	private ErrorType error;
	
	// The message is solely intented for internal purpose - debugging.
	// The customer will not see the message, its sole purpose is to shorten the debugging period of the
	// programmer, by supplying him an description of the problem
	
	// ALSO
	// This Ctor's format, is an example to a situation in which we're the ones throwing the exception
	// and we do not need to "wrap" another exception
	public ApplicationException(TypeError errorType, String message){
		// Exception class has a constructor which gets a message as a parameter.
		// This way, when we call e.printStackTrace(), the message which has been transferred to the 
		// Ctor (super()), will be displayed.
		super(message);
		this.errorType = errorType;
	}
	
	
	// This is an example to the Ctor which will be used when we "wrap" a 3rd party exception
	public ApplicationException(TypeError errorType, SQLException e, String message){

		// Sending the "e" parameter to super(), preseves the information in e, which helps us to understand and actually
		// see during e.printStackTrace(), the actual reason of the error.
		super(message, e);
		this.errorType = errorType;
	}



	public ApplicationException(ErrorType error, String message) {
		super();
		
		
	}


	public TypeError getErrorType() {
		return errorType;
	}
	
	
}
