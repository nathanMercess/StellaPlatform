package br.com.linceit.stella.bean;

import java.util.List;

public class Avaliacao {
	private Integer cdAvaliacao;// CD_AVALIACAO
	private String titulo;// DS_TITULO
	private Integer qtdeQuestao;// NR_QTDE_QUESTAO
	private Disciplina disciplina;// CD_DISCIPLINA
	private List<Questao> questoes;
	
	public Avaliacao() {
	}

	public Avaliacao(Integer cdAvaliacao, String titulo, Integer qtdeQuestao, Disciplina disciplina) {
		super();
		this.cdAvaliacao = cdAvaliacao;
		this.titulo = titulo;
		this.qtdeQuestao = qtdeQuestao;
		this.disciplina = disciplina;
	}

	public Avaliacao(Integer cdAvaliacao) {
		this.cdAvaliacao = cdAvaliacao;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public Integer getCdAvaliacao() {
		return cdAvaliacao;
	}

	public void setCdAvaliacao(Integer cdAvaliacao) {
		this.cdAvaliacao = cdAvaliacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getQtdeQuestao() {
		return qtdeQuestao;
	}

	public void setQtdeQuestao(Integer qtdeQuestao) {
		this.qtdeQuestao = qtdeQuestao;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Avaliacao [cdAvaliacao=" + cdAvaliacao + ", titulo=" + titulo + ", qtdeQuestao=" + qtdeQuestao
				+ ", disciplina=" + disciplina + ", questoes=" + questoes + "]";
	}
	
	
}
