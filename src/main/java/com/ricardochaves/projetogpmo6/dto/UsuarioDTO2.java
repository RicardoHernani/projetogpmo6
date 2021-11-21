package com.ricardochaves.projetogpmo6.dto;

import java.io.Serializable;

import com.ricardochaves.projetogpmo6.domain.Usuario;

/*Classe DTO para trafegar dados do usuário, nome, email e senha
sem mostrar os procedimentos*/
public class UsuarioDTO2 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private String email;
	private String senha;
	
	public UsuarioDTO2() {
	}
	
	public UsuarioDTO2(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		senha = obj.getSenha();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
