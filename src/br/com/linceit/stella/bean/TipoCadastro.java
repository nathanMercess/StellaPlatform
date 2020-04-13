package br.com.linceit.stella.bean;

public enum TipoCadastro {
	ADMIN("ADMIN"),ALUNO("ALUNO");
	
	private final String ds;
	
	private TipoCadastro(String ds) {
		this.ds = ds;
	}
	
	@Override
	public String toString() {
		return ds;
	}
}
