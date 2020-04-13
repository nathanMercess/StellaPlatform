package br.com.linceit.stella.bean;

public class Progressao {
	private Integer cdMatricula;// CD_MATRICULA
	private Integer cdConteudo;// CD_CONTEUDO
	private Boolean concluido;// ST_CONCLUIDO
	private Integer avaliacao;// VL_AVALIACAO
	
	public Progressao() {
	}
	
	public Progressao(Integer cdMatricula, Integer conteudo, Boolean concluido, Integer avaliacao) {
		super();
		this.cdMatricula = cdMatricula;
		this.cdConteudo = conteudo;
		this.concluido = concluido;
		this.avaliacao = avaliacao;
	}

	public Integer getCdMatricula() {
		return cdMatricula;
	}

	public void setCdMatricula(Integer cdMatricula) {
		this.cdMatricula = cdMatricula;
	}

	public Integer getCdConteudo() {
		return cdConteudo;
	}

	public void setCdConteudo(Integer conteudo) {
		this.cdConteudo = conteudo;
	}
	
	public Boolean getConcluido() {
		return concluido;
	}

	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

}
