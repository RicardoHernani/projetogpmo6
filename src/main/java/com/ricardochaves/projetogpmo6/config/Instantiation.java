package com.ricardochaves.projetogpmo6.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ricardochaves.projetogpmo6.domain.Procedimento;
import com.ricardochaves.projetogpmo6.domain.Referencia;
import com.ricardochaves.projetogpmo6.domain.Usuario;
import com.ricardochaves.projetogpmo6.domain.enums.TipoPremio;
import com.ricardochaves.projetogpmo6.domain.enums.TipoProcedimento;
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
		
		Referencia ref1 = new Referencia(null, "31102360", "Ureterorrenolitotripisia Flexivel Unilateral", 41.0, 992.0);
		Referencia ref2 = new Referencia(null, "31102077", "descrição 1", 41.0, 992.0);
		Referencia ref3 = new Referencia(null, "30908027", "descrição 2", 40.0, 1000.0);
		Referencia ref4 = new Referencia(null, "30202094", "descrição 3", 40.0, 1100.0);
		Referencia ref5 = new Referencia(null, "30715016", "descrição 4", 42.0, 800.0);
		Referencia ref6 = new Referencia(null, "31201113", "descrição 5", 43.0, 700.0);
		Referencia ref7 = new Referencia(null, "30914070", "descrição 6", 444.0, 600.0);
		Referencia ref8 = new Referencia(null, "30908027", "descrição 7", 45.0, 500.0);
		Referencia ref9 = new Referencia(null, "31003567", "descrição 8", 46.0, 400.0);
		Referencia ref10 = new Referencia(null, "30729017", "descrição 9", 47.0, 300.0);

		
		usuarioRepository.saveAll(Arrays.asList(ricardo, debora, ana));
		
		Procedimento pro1 = new Procedimento(null, 11111111, sdf.parse("20/02/2020"), TipoProcedimento.PRINCIPAL, TipoPremio.DINHEIRO, "31102360", ref1, new UsuarioDTO(ricardo));
		Procedimento pro2 = new Procedimento(null, 11111111, sdf.parse("26/02/2020"), TipoProcedimento.SECUNDARIO, TipoPremio.DINHEIRO, "31102077", ref2, new UsuarioDTO(ricardo));
		Procedimento pro3 = new Procedimento(null, 11111111, sdf.parse("26/05/2011"), TipoProcedimento.PRINCIPAL, TipoPremio.DINHEIRO, "30908027", ref3, new UsuarioDTO(ricardo));
		Procedimento pro4 = new Procedimento(null, 22222222, sdf.parse("10/10/2009"), TipoProcedimento.PRINCIPAL, TipoPremio.TAREFABASICA, "30202094",ref4, new UsuarioDTO(debora));
		Procedimento pro5 = new Procedimento(null, 33333333, sdf.parse("15/08/2013"), TipoProcedimento.PRINCIPAL, TipoPremio.DINHEIRO, "30715016",ref5, new UsuarioDTO(debora));
		Procedimento pro6 = new Procedimento(null, 44444444, sdf.parse("07/02/2000"), TipoProcedimento.PRINCIPAL, TipoPremio.TAREFABASICA, "31003567",ref9, new UsuarioDTO(ana));
		Procedimento pro7 = new Procedimento(null, 44444444, sdf.parse("07/02/2000"), TipoProcedimento.SECUNDARIO, TipoPremio.TAREFABASICA, "30729017", ref10, new UsuarioDTO(ana));
		Procedimento pro8 = new Procedimento(null, 44444444, sdf.parse("24/12/2010"), TipoProcedimento.PRINCIPAL, TipoPremio.DINHEIRO, "30908027", ref3, new UsuarioDTO(ana));
		Procedimento pro9 = new Procedimento(null, 55555555, sdf.parse("13/05/1998"), TipoProcedimento.PRINCIPAL, TipoPremio.TAREFABASICA, "31201113", ref6, new UsuarioDTO(ana));
		Procedimento pro10 = new Procedimento(null, 66666666, sdf.parse("27/06/2019"), TipoProcedimento.PRINCIPAL, TipoPremio.TAREFABASICA, "30908027", ref3, new UsuarioDTO(ana));

		procedimentoRepository.saveAll(Arrays.asList(pro1, pro2, pro3, pro4, pro5, pro6, pro7, pro8, pro9, pro10));
		
		ricardo.getProcedimentos().addAll(Arrays.asList(pro1, pro2, pro3));
		debora.getProcedimentos().addAll(Arrays.asList(pro4, pro5));
		ana.getProcedimentos().addAll(Arrays.asList(pro6, pro7, pro8, pro9, pro10));
		
		usuarioRepository.saveAll(Arrays.asList(ricardo, debora, ana));
		
	}

}
