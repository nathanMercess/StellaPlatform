package br.com.linceit.stella.bean;

public class Conteudo {
	
	
	private Integer cdConteudo;//CD_CONTEUDO
	private Disciplina disciplina;//CD_DISCIPLINA
	private String nome;//NM_CONTEUDO
	private String localDoc;//DS_LOCAL_DOC
	
	public Conteudo() {}
	
	public Conteudo(Integer cdConteudo) {
		this.cdConteudo = cdConteudo;
	}
	
	public Conteudo(Integer cdConteudo, Disciplina disciplina, String nome, String localDoc) {
		super();
		this.cdConteudo = cdConteudo;
		this.disciplina = disciplina;
		this.nome = nome;
		this.localDoc = localDoc;
	}
	
	public Integer getCdConteudo() {
		return cdConteudo;
	}

	public void setCdConteudo(Integer cdConteudo) {
		this.cdConteudo = cdConteudo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalDoc() {
		return localDoc;
	}

	public void setLocalDoc(String localDoc) {
		this.localDoc = localDoc;
	}

}
