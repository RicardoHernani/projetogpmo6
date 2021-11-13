
package com.ricardochaves.projetogpmo6.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Procedimento>> findAll() {
		List <Procedimento> list = procedimentoService.findAll();
		return ResponseEntity.ok().body(list);

	}

}