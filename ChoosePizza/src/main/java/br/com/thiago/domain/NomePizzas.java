package br.com.thiago.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.thiago.service.TipoDadoEspecifico;

public class NomePizzas extends TipoDadoEspecifico<String> {

	@Override
	public List<String> getDados() {
		List<String> nomes = new ArrayList<>();
		nomes.add("queijo");
		nomes.add("baiana");
		return nomes;
	}

}
