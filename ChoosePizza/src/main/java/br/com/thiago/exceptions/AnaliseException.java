package br.com.thiago.exceptions;

public class AnaliseException extends RuntimeException {

	private static final long serialVersionUID = 1127708718352870544L;
	
	@Override
	public String getMessage() {
		return "Ninguem gosta dessa pizza :/, que triste";
	}
}
