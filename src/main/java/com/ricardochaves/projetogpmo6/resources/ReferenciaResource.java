package com.ricardochaves.projetogpmo6.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricardochaves.projetogpmo6.domain.Referencia;
import com.ricardochaves.projetogpmo6.resources.util.URL;
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
	
	@RequestMapping(value="/descricaosearch", method=RequestMethod.GET)
	public ResponseEntity<List<Referencia>> findByDescricao(
			@RequestParam(value="text", defaultValue="") String text) {
			text = URL.decodeParam(text);
			List<Referencia> list = referenciaService.findByDescricao(text);
			return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/descricaosearch/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Referencia>> findPage(
			@RequestParam(value="text", defaultValue="") String text, 
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="text") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
			text = URL.decodeParam(text);
			Page<Referencia> list = referenciaService.findByDescricao(text, page, linesPerPage, orderBy, direction);
			return ResponseEntity.ok().body(list);
	}

}
