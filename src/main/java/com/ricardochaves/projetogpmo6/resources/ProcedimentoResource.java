
package com.ricardochaves.projetogpmo6.resources;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Procedimento obj) {
		obj = procedimentoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		procedimentoService.delete(id);
		return ResponseEntity.noContent().build(); 
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> updateProcedimento(@RequestBody Procedimento obj, @PathVariable String id) {
		obj.setId(id);
		obj = procedimentoService.updateProcedimento(obj);
		return ResponseEntity.noContent().build(); 
	}

	@RequestMapping(value="/fullsearch/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Procedimento>> findPage(
			@RequestParam(value="nomeUsuario", defaultValue="") String nomeUsuario, 
			@RequestParam(value="dataInicial", defaultValue="") String dataInicial,
			@RequestParam(value="dataFinal", defaultValue="") String dataFinal,
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="text") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
			Date inicio = URL.convertDate(dataInicial, new Date(0L));
			Date fim = URL.convertDate(dataFinal, new Date());
			Page<Procedimento> list = procedimentoService.findByDate(nomeUsuario, inicio, fim, page, linesPerPage, orderBy, direction);
			return ResponseEntity.ok().body(list);
	}
}