package com.example.webanbanhang.valid;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.webanbanhang.model.CustomerForm;

@Component
public class CustomerFormValidator implements Validator {
	private EmailValidator emailValidtor = EmailValidator.getInstance();

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == CustomerForm.class;

	}

	@Override
	public void validate(Object target, Errors errors) {
		CustomerForm custInfo = (CustomerForm) target;

		// Kiểm tra các trường (field) của CustomerForm.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.customerForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.customerForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.customerForm.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.customerForm.phone");

		if (!emailValidtor.isValid(custInfo.getEmail())) {
			errors.rejectValue("email", "Pattern.customerForm.email");
		}

	}

}
