package br.com.linceit.stella.dto;

public class ConteudoProgressao {
	
	private String tituloConteudo;
	private Integer cdConteudo;
	private Boolean avaliado;
	
	public ConteudoProgressao(String tituloConteudo, Integer cdConteudo, Boolean avaliado) {
		super();
		this.tituloConteudo = tituloConteudo;
		this.cdConteudo = cdConteudo;
		this.avaliado = avaliado;
	}

	public String getTituloConteudo() {
		return tituloConteudo;
	}

	public Integer getCdConteudo() {
		return cdConteudo;
	}

	public Boolean getAvaliado() {
		return avaliado;
	}
	
}
