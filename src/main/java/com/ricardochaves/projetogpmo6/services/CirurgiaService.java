package com.ricardochaves.projetogpmo6.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardochaves.projetogpmo6.domain.Cirurgia;
import com.ricardochaves.projetogpmo6.repositories.CirurgiaRepository;

@Service
public class CirurgiaService {

	@Autowired
	private CirurgiaRepository cirurgiaRepository;
	
	public List<Cirurgia> findAll(){
			return cirurgiaRepository.findAll();
	}
	
}