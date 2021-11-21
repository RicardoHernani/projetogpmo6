package com.ricardochaves.projetogpmo6.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ricardochaves.projetogpmo6.domain.Procedimento;
import com.ricardochaves.projetogpmo6.repositories.ProcedimentoRepository;
import com.ricardochaves.projetogpmo6.services.exception.ObjectNotFoundException;

@Service
public class ProcedimentoService {

	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	@Autowired
	private ProcedimentoService procedimentoService;
		
	@Autowired
	private ReferenciaService referenciaService;
	
	public Procedimento findById(String id) {
		Optional<Procedimento> obj = procedimentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Procedimento não encontrado"));
		}
	
	public List<Procedimento> fullSearch(String nomeUsuario, Date dataInicial, Date dataFinal) {
		dataFinal = new Date(dataFinal.getTime() + 24 * 60 * 60 * 1000);
		return procedimentoRepository.fullSearch(nomeUsuario, dataInicial, dataFinal);
	}
	
	@Transactional
	public Procedimento insert(Procedimento obj) {
		obj.setId(null);	
		obj.getMatricula();
		obj.getData();
		obj.getTipo();
		obj.getPremio();
		obj.setReferencia(referenciaService.findByCodigo(obj.getCodigo()));
		obj = procedimentoRepository.save(obj);		
		return obj;	
		/*Não precisa colocar o id ou nome em um get pois a jpa já faz isso em um objeto já
		existente. Colocar apenas na requisição html.*/
	}
		
	public void delete(String id) {
		findById(id);
		procedimentoRepository.deleteById(id);
	}
	
	public Procedimento updateProcedimento(Procedimento obj) {
		Procedimento newObj = procedimentoService.findById(obj.getId());  
		updateData(newObj, obj);							   
		return procedimentoRepository.save(newObj);
	}

	private void updateData(Procedimento newObj, Procedimento obj) {
		newObj.setMatricula(obj.getMatricula());
		newObj.setData(obj.getData());
		newObj.setTipo(obj.getTipo());
		newObj.setPremio(obj.getPremio());
		newObj.setCodigo(obj.getCodigo());
		newObj.setReferencia(referenciaService.findByCodigo(obj.getCodigo()));
	}
			
}