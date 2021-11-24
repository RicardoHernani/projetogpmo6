package com.ricardochaves.projetogpmo6.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Procedimento findById(String id) {
		Optional<Procedimento> obj = procedimentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Procedimento não encontrado! id: " + id
				+ ", Tipo: " + Procedimento.class.getName()));
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
		obj.getUsuario().getId();
		obj.setReferencia(referenciaService.findByCodigo(obj.getCodigo()));
		obj = procedimentoRepository.save(obj);		
		return obj;	
		
		/*Não precisa colocar o id ou nome em um get pois a jpa já faz isso em um objeto já
		existente. Colocar apenas na requisição html.
		
		obj.getUsuario().setNome(usuarioService.findById(obj.getUsuario().getId()));
*/
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
	
	public Page<Procedimento> findByDate(String nomeUsuario, Date dataInicial, Date dataFinal, Integer page, Integer linesPerPage, String orderBy, String direction) {
		dataFinal = new Date(dataFinal.getTime() + 24 * 60 * 60 * 1000);
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return procedimentoRepository.dateIntervalSearch(nomeUsuario, dataInicial, dataFinal, pageRequest);
	}
			
}