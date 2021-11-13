package com.ricardochaves.projetogpmo6.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ricardochaves.projetogpmo6.domain.Procedimento;

@Repository
public interface ProcedimentoRepository extends MongoRepository<Procedimento, String> {

}