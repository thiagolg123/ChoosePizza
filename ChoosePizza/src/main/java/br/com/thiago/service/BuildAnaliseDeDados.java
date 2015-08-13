package br.com.thiago.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.thiago.model.Analise;
import br.com.thiago.model.Pizza;

public class BuildAnaliseDeDados extends BuildAnalise{

	private String nomePessoa;
	private List<Map<String, List<Pizza>>> dadosParaAnalise;
	private String nomePessoaComQuemDividir;
	
	public BuildAnaliseDeDados(String nomePessoa, List<Map<String, List<Pizza>>> dadosParaAnalise) {
		this.nomePessoa = nomePessoa;		
		this.dadosParaAnalise = dadosParaAnalise;
	}

	
	public Analise buildAnalise() {
		Analise analise = new Analise();
		
		StringBuilder sb = new StringBuilder();
		sb.append(nomePessoa);
		sb.append(" divide pizza de ");
		sb.append(getPizzaMaiorNotaUmaPessoa(nomePessoa, dadosParaAnalise).getNome());
		sb.append(" com ");
		sb.append(nomePessoaComQuemDividir);
		
		analise.setTextAnalise(sb.toString());
		return analise;
	}


	public BuildAnaliseDeDados getAnaliseByName() {
		Iterator<Map<String, List<Pizza>>> itDadosAnalise = dadosParaAnalise.iterator();
		List<String> nomePessoas = new ArrayList<>();

		while(itDadosAnalise.hasNext()){
			nomePessoas.add(itDadosAnalise.next().keySet().iterator().next());
		}

		nomePessoaComQuemDividir = getNomeComQuemDividir(getPizzaMaiorNotaDeTodos(nomePessoas, dadosParaAnalise));
		return this;
	}

	public Pizza getPizzaMaiorNota() {
		return getPizzaMaiorNotaUmaPessoa(nomePessoa, dadosParaAnalise);
	}
}
