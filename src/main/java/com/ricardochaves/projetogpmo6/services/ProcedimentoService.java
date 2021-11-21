package com.ricardochaves.projetogpmo6.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ricardochaves.projetogpmo6.domain.Procedimento;
import com.ricardochaves.projetogpmo6.repositories.ProcedimentoRepository;
import com.ricardochaves.projetogpmo6.repositories.ReferenciaRepository;
import com.ricardochaves.projetogpmo6.repositories.UsuarioRepository;
import com.ricardochaves.projetogpmo6.services.exception.ObjectNotFoundException;

@Service
public class ProcedimentoService {

	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ReferenciaService referenciaService;
	
	@Autowired
	private ReferenciaRepository referenciaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProcedimentoService procedimentoService;
	
	public Procedimento findById(String id) {
		Optional<Procedimento> obj = procedimentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
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
		
		//usuario.setId(obj.getId());

		obj = procedimentoRepository.save(obj);
		
		return obj;
	}
	
}