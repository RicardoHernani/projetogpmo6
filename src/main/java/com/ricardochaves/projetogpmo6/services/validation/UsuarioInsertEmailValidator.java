package com.ricardochaves.projetogpmo6.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ricardochaves.projetogpmo6.domain.Usuario;
import com.ricardochaves.projetogpmo6.repositories.UsuarioRepository;
import com.ricardochaves.projetogpmo6.resources.exception.FieldMessage;

public class UsuarioInsertEmailValidator implements ConstraintValidator<UsuarioInsertEmail, Usuario> {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void initialize(UsuarioInsertEmail ann) {
	}

	@Override
	public boolean isValid(Usuario obj, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		Usuario aux = usuarioRepository.findByEmail(obj.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("Email", "O Email já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
