package br.com.thiago.enums;

public enum NomePizzas {

	PORTUGUESA("Portuguesa"), MARGUERITA("Marguerita");

	private final String text;

	private NomePizzas(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
