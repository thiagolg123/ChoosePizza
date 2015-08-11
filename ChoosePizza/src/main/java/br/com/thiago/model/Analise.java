package br.com.thiago.model;

public class Analise {

	private String textAnalise;
	
	public Analise(){}
	
	public Analise(String textAnalise){
		this.textAnalise = textAnalise;
	}

	public String getTextAnalise() {
		return textAnalise;
	}

	public void setTextAnalise(String textAnalise) {
		this.textAnalise = textAnalise;
	}
	
	@Override
	public String toString() {
		return getTextAnalise();
	}
}
