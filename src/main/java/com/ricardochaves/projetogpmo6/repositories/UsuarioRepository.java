package com.ricardochaves.projetogpmo6.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ricardochaves.projetogpmo6.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	@Transactional(readOnly=true)
	Usuario findByEmail (String email);
	
	@Transactional(readOnly=true)
	Usuario findByNome (String nome);

}

