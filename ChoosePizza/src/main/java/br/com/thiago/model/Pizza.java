package br.com.thiago.model;

import br.com.thiago.enums.NomePizzas;
import br.com.thiago.enums.NotaPizza;

public class Pizza {

	private NomePizzas nome;
	private NotaPizza nota;
	
	public Pizza(){}
	
	public Pizza(NomePizzas nomePizza, NotaPizza notaPizza){
		this.nome = nomePizza;
		this.nota = notaPizza;
	}

	public NotaPizza getNota() {
		return nota;
	}

	public void setNota(NotaPizza nota) {
		this.nota = nota;
	}

	public NomePizzas getNome() {
		return nome;
	}

	public void setNome(NomePizzas nome) {
		this.nome = nome;
	}
}
