package com.ricardochaves.projetogpmo6.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ricardochaves.projetogpmo6.domain.Procedimento;

@Repository
public interface ProcedimentoRepository extends MongoRepository<Procedimento, String> {
	
	@Query("{ $and: [ {'usuario.nome': ?0}, { data: { $gte: ?1} }, { data: { $lte: ?2} } ] }")
	List<Procedimento> fullSearch(String nomeUsuario, Date dataInicial, Date dataFinal);
	
	@Query("{ $and: [ {'usuario.nome': ?0}, { data: { $gte: ?1} }, { data: { $lte: ?2} } ] }")
	Page<Procedimento> dateIntervalSearch (String nomeUsuario, Date dataInicial, Date dataFinal, Pageable pageRequest);
	
}

//Quando colocar o caminho do campo este deve vir entre aspas simples como em 'usuario.nome'
