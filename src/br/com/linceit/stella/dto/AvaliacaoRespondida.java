package br.com.linceit.stella.dto;

import java.util.List;

public class AvaliacaoRespondida {

	private Integer cdAvaliacao;
	private Integer cdDisciplina;
	private Integer cdMatricula;
	
	public Integer getCdDisciplina() {
		return cdDisciplina;
	}

	public void setCdDisciplina(Integer cdDisciplina) {
		this.cdDisciplina = cdDisciplina;
	}

	public Integer getCdMatricula() {
		return cdMatricula;
	}

	public void setCdMatricula(Integer cdMatricula) {
		this.cdMatricula = cdMatricula;
	}

	private List<RespostaQuestao> respostas;

	public Integer getCdAvaliacao() {
		return cdAvaliacao;
	}

	public void setCdAvaliacao(Integer cdAvaliacao) {
		this.cdAvaliacao = cdAvaliacao;
	}

	public List<RespostaQuestao> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaQuestao> respostas) {
		this.respostas = respostas;
	}
	
	@Override
	public String toString() {
		return "AvaliacaoRespondida [cdAvaliacao=" + cdAvaliacao + ", cdDisciplina=" + cdDisciplina + ", cdMatricula="
				+ cdMatricula + ", respostas=" + respostas + "]";
	}
}
