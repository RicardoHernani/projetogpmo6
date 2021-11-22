package com.ricardochaves.projetogpmo6.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ricardochaves.projetogpmo6.domain.Usuario;
import com.ricardochaves.projetogpmo6.dto.UsuarioDTO;
import com.ricardochaves.projetogpmo6.dto.UsuarioDTO2;
import com.ricardochaves.projetogpmo6.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List <Usuario> list = usuarioService.findAll();
		List<UsuarioDTO> listDto = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto); 
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UsuarioDTO2> findById(@PathVariable String id) {
		Usuario obj = usuarioService.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO2(obj)); 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Usuario obj) {
		obj = usuarioService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		usuarioService.delete(id);
		return ResponseEntity.noContent().build(); 
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> updateSenha(@RequestBody Usuario obj, @PathVariable String id) {
		obj.setId(id);
		obj = usuarioService.updateSenha(obj);
		return ResponseEntity.noContent().build(); 
	}
	
}
