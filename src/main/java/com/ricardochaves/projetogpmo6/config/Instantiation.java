package com.ricardochaves.projetogpmo6.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ricardochaves.projetogpmo6.domain.Usuario;
import com.ricardochaves.projetogpmo6.repositories.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepository.deleteAll();
		
		Usuario ricardo = new Usuario(null, "Ricardo", "ricardo@gmail", "12345");
		Usuario debora = new Usuario(null, "Débora", "debora@gmail", "1234");
		Usuario ana = new Usuario(null, "Ana", "ana@gmail", "123");
		
		usuarioRepository.saveAll(Arrays.asList(ricardo, debora, ana));
	}

}
