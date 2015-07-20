package br.com.thiago.service.impl;

import java.util.List;

import br.com.thiago.service.DadosService;
import br.com.thiago.service.TipoDadoEspecifico;

public class DadosNomePizza implements DadosService<String>{

	@Override
	public List<String> getDados(TipoDadoEspecifico<String> tipoDado) {
		return tipoDado.getDados();
	}





}
