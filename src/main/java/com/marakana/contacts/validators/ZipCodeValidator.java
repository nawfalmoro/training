package com.marakana.contacts.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

	@Override
	public void initialize(ZipCode zipCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String zipCode, ConstraintValidatorContext context) {
		if (zipCode.length() != 5)
			return false;
		for (char c : zipCode.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

}
