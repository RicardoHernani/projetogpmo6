package com.ricardochaves.projetogpmo6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ricardochaves.projetogpmo6.domain.Referencia;
import com.ricardochaves.projetogpmo6.repositories.ReferenciaRepository;
import com.ricardochaves.projetogpmo6.services.exception.ObjectNotFoundException;

@Service
public class ReferenciaService {

	@Autowired
	private ReferenciaRepository referenciaRepository;
	
	public Referencia findByCodigo(String codigoTabela) {
		Optional<Referencia> obj = referenciaRepository.findByCodigoEquals(codigoTabela);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Código não encontrado"));
		}
	
	public List<Referencia> findByDescricao(String text) {
		return referenciaRepository.findByDescricaoContainingIgnoreCase(text);
	}
	
	public Page<Referencia> findByDescricao(String text, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return referenciaRepository.findByDescricaoContainingIgnoreCase(text, pageRequest);
	}
	
}
