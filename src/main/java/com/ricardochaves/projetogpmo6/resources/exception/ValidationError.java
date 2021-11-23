package com.ricardochaves.projetogpmo6.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);		
	}

	public List<FieldMessage> getErrors() {			//lembrar que no java o que importa é o que
		return errors;								//está no método get. No caso getErrors. A palavra Errors que será convertida no json
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}

}
