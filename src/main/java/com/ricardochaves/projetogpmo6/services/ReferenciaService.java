package com.ricardochaves.projetogpmo6.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardochaves.projetogpmo6.domain.Referencia;
import com.ricardochaves.projetogpmo6.repositories.ReferenciaRepository;
import com.ricardochaves.projetogpmo6.services.exception.ObjectNotFoundException;

@Service
public class ReferenciaService {

	@Autowired
	private ReferenciaRepository referenciaRepository;
	
	public Referencia findByCodigo(String codigoTabela) {
		Optional<Referencia> obj = referenciaRepository.findByCodigoContaining(codigoTabela);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Código não encontrado"));
		}
}
