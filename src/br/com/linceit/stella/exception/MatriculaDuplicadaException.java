package br.com.linceit.stella.exception;

public class MatriculaDuplicadaException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MatriculaDuplicadaException() {
		super("O aluno ja esta matriculado nesta disciplina");
	}

}
