package com.ricardochaves.projetogpmo6.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardochaves.projetogpmo6.domain.Paciente;
import com.ricardochaves.projetogpmo6.repositories.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public List<Paciente> findAll(){
			return pacienteRepository.findAll();
	}
	
}
