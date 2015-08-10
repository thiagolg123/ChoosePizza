package br.com.thiago.enums;

public enum NotaPizza {
	UM(1),
	DOIS(2),
	TRES(3),
	QUATRO(4),
	CINCO(5);
	
	private int value;
	
	private NotaPizza(final int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
