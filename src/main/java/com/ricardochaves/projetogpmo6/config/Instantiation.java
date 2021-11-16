package com.ricardochaves.projetogpmo6.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ricardochaves.projetogpmo6.domain.Procedimento;
import com.ricardochaves.projetogpmo6.domain.Usuario;
import com.ricardochaves.projetogpmo6.dto.UsuarioDTO;
import com.ricardochaves.projetogpmo6.repositories.ProcedimentoRepository;
import com.ricardochaves.projetogpmo6.repositories.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepository.deleteAll();
		procedimentoRepository.deleteAll();
		
		Usuario ricardo = new Usuario(null, "Ricardo", "ricardo@gmail", "12345");
		Usuario debora = new Usuario(null, "Débora", "debora@gmail", "1234");
		Usuario ana = new Usuario(null, "Ana", "ana@gmail", "123");
		
		usuarioRepository.saveAll(Arrays.asList(ricardo, debora, ana));
		
		Procedimento pro1 = new Procedimento(null, 11111111, sdf.parse("20/02/2020"), 1, 1, "31102360", new UsuarioDTO(ricardo));
		Procedimento pro2 = new Procedimento(null, 11111111, sdf.parse("26/02/2020"), 2, 1, "31102077", new UsuarioDTO(ricardo));
		Procedimento pro3 = new Procedimento(null, 11111111, sdf.parse("26/05/2011"), 1, 1, "30908027", new UsuarioDTO(ricardo));
		Procedimento pro4 = new Procedimento(null, 22222222, sdf.parse("10/10/2009"), 1, 2, "30202094", new UsuarioDTO(debora));
		Procedimento pro5 = new Procedimento(null, 33333333, sdf.parse("15/08/2013"), 1, 1, "30715016", new UsuarioDTO(debora));
		Procedimento pro6 = new Procedimento(null, 44444444, sdf.parse("07/02/2000"), 1, 2, "31201113", new UsuarioDTO(ana));
		Procedimento pro7 = new Procedimento(null, 44444444, sdf.parse("07/02/2000"), 2, 2, "30914070", new UsuarioDTO(ana));
		Procedimento pro8 = new Procedimento(null, 44444444, sdf.parse("24/12/2010"), 1, 1, "30908027", new UsuarioDTO(ana));
		Procedimento pro9 = new Procedimento(null, 55555555, sdf.parse("13/05/1998"), 1, 2, "31003567", new UsuarioDTO(ana));
		Procedimento pro10 = new Procedimento(null, 66666666, sdf.parse("27/06/2019"), 1, 2, "30729017", new UsuarioDTO(ana));

		procedimentoRepository.saveAll(Arrays.asList(pro1, pro2, pro3, pro4, pro5, pro6, pro7, pro8, pro9, pro10));
		
		ricardo.getProcedimentos().addAll(Arrays.asList(pro1, pro2, pro3));
		debora.getProcedimentos().addAll(Arrays.asList(pro4, pro5));
		ana.getProcedimentos().addAll(Arrays.asList(pro6, pro7, pro8, pro9, pro10));
		
		usuarioRepository.saveAll(Arrays.asList(ricardo, debora, ana));
		
	}

}
