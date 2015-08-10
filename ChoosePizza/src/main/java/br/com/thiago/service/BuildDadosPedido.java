package br.com.thiago.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.thiago.model.Pessoa;
import br.com.thiago.model.Pizza;

public class BuildDadosPedido {

	public static Map<String, List<Pizza>> toMap(Pessoa pessoa, List<Pizza> pizzas) {
		Map<String, List<Pizza>> mapPizza = new HashMap<>();
		
		mapPizza.put(pessoa.getNome(), pizzas);
		
		return mapPizza;
	}
}
