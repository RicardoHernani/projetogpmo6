package com.ricardochaves.projetogpmo6.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardochaves.projetogpmo6.domain.Paciente;
import com.ricardochaves.projetogpmo6.services.PacienteService;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService pacienteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Paciente>> findAll() {
		List <Paciente> list = pacienteService.findAll();
		return ResponseEntity.ok().body(list);

	}

}