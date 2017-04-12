package com.elior.coupons.utilss;


import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class ValidationUtil{
	
	
	//chking with rgex the validation of the emeil
		public static boolean isEmailValid(String email) {
			
			String EMAIL_PATTERN =
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			Matcher matcher = pattern.matcher(email);
			
			return matcher.matches();
		}
		
		//chking with rgex the validation of the password
	
		public static boolean isPasswordValid(String password) {
			String PASS_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!$%^&+=])(?=\\S+$).{8,}";
			Pattern pattern = Pattern.compile(PASS_PATTERN);
			Matcher matcher = pattern.matcher(password);
			
			return matcher.matches();
		}

	



	
}






