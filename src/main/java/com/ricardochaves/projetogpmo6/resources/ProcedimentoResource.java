
package com.ricardochaves.projetogpmo6.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardochaves.projetogpmo6.domain.Procedimento;
import com.ricardochaves.projetogpmo6.services.ProcedimentoService;

@RestController
@RequestMapping(value="/procedimentos")
public class ProcedimentoResource {
	
	@Autowired
	private ProcedimentoService procedimentoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Procedimento> findById(@PathVariable String id) {
		Procedimento obj = procedimentoService.findById(id);
		return ResponseEntity.ok().body(obj);

	}

}