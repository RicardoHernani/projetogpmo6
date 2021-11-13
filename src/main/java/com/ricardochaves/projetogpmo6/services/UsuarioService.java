package com.ricardochaves.projetogpmo6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardochaves.projetogpmo6.domain.Usuario;
import com.ricardochaves.projetogpmo6.repositories.UsuarioRepository;
import com.ricardochaves.projetogpmo6.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
			return usuarioRepository.findAll();
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public Usuario insert(Usuario obj) {
		return usuarioRepository.insert(obj);
	}
	
	
	
}
