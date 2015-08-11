package br.com.thiago.enums;

public enum NomePizzas {

	PORTUGUESA("Portuguesa"), 
	MARGUERITA("Marguerita"),
	QUATRO_QUEIJOS("Quatro queijos"),
	ESCAROLA("Escarola");

	private final String text;

	private NomePizzas(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
