package br.com.thiago.service;

import java.util.List;

public abstract class TipoDadoEspecifico<T> implements TipoDado {
	public abstract List<T> getDados();
}
