package com.ricardochaves.projetogpmo6.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ricardochaves.projetogpmo6.domain.enums.TipoPremio;
import com.ricardochaves.projetogpmo6.domain.enums.TipoProcedimento;
import com.ricardochaves.projetogpmo6.dto.UsuarioDTO;

@Document(collection="procedimento")
public class Procedimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Positive(message="As matrículas devem ser números positivos")
	@Max(value=99999999, message="Os valores não devem exceder a 99999999")
	private Integer matricula;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data;
	
	private Integer tipo;
	private Integer premio;
	
	@Length(min=8, max=8, message="O código deve conter 8 dígitos")
	private String codigo;
	
	private Referencia referencia;
	private UsuarioDTO usuario;
	
	public Procedimento() {
	}

	public Procedimento(String id, Integer matricula, Date data, TipoProcedimento tipo, TipoPremio premio, String codigo, Referencia referencia, UsuarioDTO usuario) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.data = data;
		this.tipo = (tipo==null) ? null : tipo.getCod();
		this.premio = (premio==null) ? null : premio.getCod();
		this.codigo = codigo;
		this.referencia = referencia;
		this.usuario = usuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoProcedimento getTipo() {
		return TipoProcedimento.toEnum(tipo);
	}

	public void setTipo(TipoProcedimento tipo) {
		this.tipo = tipo.getCod();
	}

	public TipoPremio getPremio() {
		return TipoPremio.toEnum(premio);
	}

	public void setPremio(TipoPremio premio) {
		this.premio = premio.getCod();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public Referencia getReferencia() {
		return referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procedimento other = (Procedimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
