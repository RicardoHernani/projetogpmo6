package com.ricardochaves.projetogpmo6.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ricardochaves.projetogpmo6.domain.Usuario;
import com.ricardochaves.projetogpmo6.repositories.UsuarioRepository;
import com.ricardochaves.projetogpmo6.resources.exception.FieldMessage;

public class UsuarioInsertNomeValidator implements ConstraintValidator<UsuarioInsertNome, Usuario> {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void initialize(UsuarioInsertNome ann) {
	}

	@Override
	public boolean isValid(Usuario obj, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		Usuario aux = usuarioRepository.findByNome(obj.getNome());
		if (aux != null) {
			list.add(new FieldMessage("Nome", "O nome já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
