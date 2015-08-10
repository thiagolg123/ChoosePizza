package br.com.thiago.model;

import java.util.Comparator;

public class PessoaComparator implements Comparator<Pessoa> {
	@Override
	public int compare(Pessoa p1, Pessoa p2) {
		return p1.getNome().compareToIgnoreCase(p2.getNome());
	}
}
