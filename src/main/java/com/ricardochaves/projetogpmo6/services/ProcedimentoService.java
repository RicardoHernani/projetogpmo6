package com.ricardochaves.projetogpmo6.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardochaves.projetogpmo6.domain.Procedimento;
import com.ricardochaves.projetogpmo6.repositories.ProcedimentoRepository;
import com.ricardochaves.projetogpmo6.services.exception.ObjectNotFoundException;

@Service
public class ProcedimentoService {

	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	public Procedimento findById(String id) {
		Optional<Procedimento> obj = procedimentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public List<Procedimento> fullSearch(String nomeUsuario, Date dataInicial, Date dataFinal) {
		dataFinal = new Date(dataFinal.getTime() + 24 * 60 * 60 * 1000);
		return procedimentoRepository.fullSearch(nomeUsuario, dataInicial, dataFinal);
	}
	
}