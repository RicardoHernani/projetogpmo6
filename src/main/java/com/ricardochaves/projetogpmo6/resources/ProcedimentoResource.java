
package com.ricardochaves.projetogpmo6.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricardochaves.projetogpmo6.domain.Procedimento;
import com.ricardochaves.projetogpmo6.resources.util.URL;
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
	
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
	public ResponseEntity<List<Procedimento>> fullSearch(
			@RequestParam(value="nomeUsuario", defaultValue="") String nomeUsuario,
			@RequestParam(value="dataInicial", defaultValue="") String dataInicial,
			@RequestParam(value="dataFinal", defaultValue="") String dataFinal) {
		Date inicio = URL.convertDate(dataInicial, new Date(0L));
		Date fim = URL.convertDate(dataFinal, new Date());
		List<Procedimento> list = procedimentoService.fullSearch(nomeUsuario, inicio, fim);
		return ResponseEntity.ok().body(list);
	}

}