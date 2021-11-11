package com.ricardochaves.projetogpmo6.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardochaves.projetogpmo6.domain.Cirurgia;
import com.ricardochaves.projetogpmo6.services.CirurgiaService;

@RestController
@RequestMapping(value="/cirurgias")
public class CirurgiaResource {
	
	@Autowired
	private CirurgiaService cirurgiaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cirurgia>> findAll() {
		List <Cirurgia> list = cirurgiaService.findAll();
		return ResponseEntity.ok().body(list);

	}

}