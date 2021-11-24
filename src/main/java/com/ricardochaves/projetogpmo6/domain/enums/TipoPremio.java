package com.ricardochaves.projetogpmo6.domain.enums;

public enum TipoPremio {

	DINHEIRO(1, "Dinheiro"),
	TAREFABASICA(2, "Tarefa básica");
	
	private int cod;
	private String descricao;
	
	private TipoPremio(int cod, String descricao) {   //O construtor de tipo enumerado é sempre private
		this.cod = cod;								 //E o nome do tipo enumerado não muda mais uma vez que foi instanciado.
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPremio toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoPremio x : TipoPremio.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("O tipo do prêmio é inválido: " + cod);
	}
	
}
