package br.com.thiago.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.thiago.model.Analise;
import br.com.thiago.model.Pizza;

public class BuildAnaliseDeDados {

	private String nomePessoa;
	private List<Map<String, List<Pizza>>> dadosParaAnalise;
	
	public BuildAnaliseDeDados(String nomePessoa, List<Map<String, List<Pizza>>> dadosParaAnalise) {
		this.nomePessoa = nomePessoa;		
		this.dadosParaAnalise = dadosParaAnalise;
	}
	
	
	public Pizza getPizzaMaiorNota() {
		int guardaMaiorNota = 0;
		Pizza pizzaMaiorNota = new Pizza();
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


	public Analise buildAnalise() {
		Analise analise = new Analise();
		
		StringBuilder sb = new StringBuilder();
		sb.append(nomePessoa);
		sb.append(" divide pizza de ");
		sb.append(getPizzaMaiorNota().getNome());
		sb.append(" com ");
		
		analise.setTextAnalise(sb.toString());
		return analise;
	}
}
