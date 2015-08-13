package br.com.thiago.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.thiago.model.Pizza;

public abstract class BuildAnalise {

	private Pizza pizzaMaiorNota;
	private Map<String, Pizza> nomesPizzasMaioresNotas;
	
	/**
	 * @param nomePessoa
	 * @param dadosParaAnalise
	 * @return
	 */
	protected Pizza getPizzaMaiorNotaUmaPessoa(String nomePessoa, List<Map<String, List<Pizza>>> dadosParaAnalise) {
		int guardaMaiorNota = 0;
		pizzaMaiorNota = new Pizza();
		Map<String, List<Pizza>> dadosDoNome = new HashMap<>();
		
		for (Map<String, List<Pizza>> dados : dadosParaAnalise) { 
			if(dados.get(nomePessoa) != null){ 
				dadosDoNome.put(nomePessoa, dados.get(nomePessoa));
				break;
			}
		}
		
		for(int j=0; j<dadosDoNome.get(nomePessoa).size(); j++){ //pegando maior nota do nome passado
			if(dadosDoNome.get(nomePessoa).get(j).getNota().getValue() > guardaMaiorNota){
				guardaMaiorNota = dadosDoNome.get(nomePessoa).get(j).getNota().getValue();
				pizzaMaiorNota.setNome(dadosDoNome.get(nomePessoa).get(j).getNome());
				pizzaMaiorNota.setNota(dadosDoNome.get(nomePessoa).get(j).getNota());
			}
		}
		return pizzaMaiorNota;
	}
	
	/**
	 * @param nomePessoas
	 * @param dadosParaAnalise
	 * @return
	 */
	protected Map<String, Pizza> getPizzaMaiorNotaDeTodos(List<String> nomePessoas, List<Map<String, List<Pizza>>> dadosParaAnalise) {
		nomesPizzasMaioresNotas = new HashMap<String, Pizza>();
			
		for(int j=0; j<dadosParaAnalise.size(); j++){
			nomesPizzasMaioresNotas.put(nomePessoas.get(j), getPizzaMaiorNotaUmaPessoa(nomePessoas.get(j), dadosParaAnalise));
		}
		return nomesPizzasMaioresNotas;
	}
	
	protected String getNomeComQuemDividir(Map<String, Pizza> nomesPizzasFavoritas){	
		//TODO Falta ver com quem a pessoa passada vai dividir uma pizza, as pizzas favoritas ja;
		return "Renata";
	}
	
}
