package com.ricardochaves.projetogpmo6.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ricardochaves.projetogpmo6.domain.Referencia;

@Repository
public interface ReferenciaRepository extends MongoRepository<Referencia, String> {

	Optional<Referencia> findByCodigoContaining(String codigoTabela);
	
}