package com.example.algamoney.api.validation.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class AbstractValidator<T> implements Validator {

	private javax.validation.Validator validator;
	
	public AbstractValidator() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.usingContext().getValidator();
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return getClassType().equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target);
		for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, "", message);
		}
		customValidate(target, errors);
	}
	
	public abstract Class<T> getClassType();
	
	public abstract void customValidate(Object target, Errors errors);

}
