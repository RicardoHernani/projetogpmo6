package com.ricardochaves.projetogpmo6.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="referencia")
public class Referencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String codigo;    //Atenção porque coloquei String e não Integer
	private String descricao;
	private Double ponto;
	private Double valor;
	
	public Referencia() {
	}

	public Referencia(String id, String codigo, String descricao, Double ponto, Double valor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.ponto = ponto;
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPonto() {
		return ponto;
	}

	public void setPonto(Double ponto) {
		this.ponto = ponto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
		Referencia other = (Referencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
