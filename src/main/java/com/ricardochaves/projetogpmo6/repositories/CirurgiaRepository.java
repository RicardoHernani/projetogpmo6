package com.ricardochaves.projetogpmo6.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ricardochaves.projetogpmo6.domain.Cirurgia;

@Repository
public interface CirurgiaRepository extends MongoRepository<Cirurgia, String> {

}
