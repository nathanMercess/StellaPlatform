package br.com.linceit.stella.exception;

public enum ExceptionMessage {
	
	PROBLEMA_INTERNO("Ocorreu um problema interno.");
	
	private String msg;
	
	private ExceptionMessage(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return msg;
	}
	
	
}
