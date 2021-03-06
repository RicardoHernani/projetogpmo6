
package com.ricardochaves.projetogpmo6.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;  //Tive que baixar as dependências no pom.xml

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ricardochaves.projetogpmo6.services.validation.UsuarioInsertEmail;
import com.ricardochaves.projetogpmo6.services.validation.UsuarioInsertNome;

@Document(collection="usuario")
@UsuarioInsertEmail
@UsuarioInsertNome
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotEmpty(message="O nome de usuário é de preenchimento obrigatório")
	@Length(min=3, max=10, message="O nome de usuário deve conter entre 3 e 10 caracteres")
	private String nome;
	
	@NotEmpty(message="O email é de preenchimento obrigatório")
	@Email(message="O email deve ser válido")
	private String email;
	
	@NotEmpty(message="A senha é de preenchimento obrigatório")
	@Length(min=6, max=10, message="A senha deve conter entre 6 e 10 caracteres")
	private String senha;
	
	@DBRef(lazy = true)
	private List<Procedimento> procedimentos = new ArrayList<>();
	
	public Usuario() {
	}

	public Usuario(String id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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
	
	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
