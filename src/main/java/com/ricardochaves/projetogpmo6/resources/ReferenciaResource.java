package com.ricardochaves.projetogpmo6.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricardochaves.projetogpmo6.domain.Referencia;
import com.ricardochaves.projetogpmo6.services.ReferenciaService;

@RestController
@RequestMapping(value="/referencias")
public class ReferenciaResource {
	
	@Autowired
	private ReferenciaService referenciaService;
	
	@RequestMapping(value="/findcode", method=RequestMethod.GET)
	public ResponseEntity<Referencia> findByCodigo(
			@RequestParam(value="codigoTabela", defaultValue="") String codigoTabela) {
			Referencia obj = referenciaService.findByCodigo(codigoTabela);
			return ResponseEntity.ok().body(obj);
	}
	

}
