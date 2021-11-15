package com.ricardochaves.projetogpmo6.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ricardochaves.projetogpmo6.domain.Procedimento;

@Repository
public interface ProcedimentoRepository extends MongoRepository<Procedimento, String> {
	
	@Query("{ $and: [ {'usuario.nome': ?0}, { data: { $gte: ?1} }, { data: { $lte: ?2} } ] }")
	List<Procedimento> fullSearch(String nomeUsuario, Date dataInicial, Date dataFinal);
	
}

//Quando colocar o caminho do campo este deve vir entre aspas simples com em 'usuario.nome'
//Consultas com dbRef não funcionam