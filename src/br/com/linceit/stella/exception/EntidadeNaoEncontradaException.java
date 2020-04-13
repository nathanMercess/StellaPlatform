package br.com.linceit.stella.exception;

public class EntidadeNaoEncontradaException extends Exception {
	
	public static final String ALUNO = "ALUNO";
	public static final String DISCIPLINA = "DISCIPLINA";
	public static final String ADMINISTRADOR = "ADMINISTRADOR";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}
	
}
