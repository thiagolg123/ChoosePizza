package br.com.thiago.service;

import java.util.List;

public interface DadosService<T>{
	public List<T> getDados(TipoDadoEspecifico<T> tipoDado);
}
