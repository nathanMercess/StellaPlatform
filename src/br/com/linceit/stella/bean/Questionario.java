package br.com.linceit.stella.bean;

public class Questionario {

	private Avaliacao avaliacao;// CD_AVALIACAO
	private Questao questao;// CD_QUESTAO
	
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Questao getQuestao() {
		return questao;
	}
	
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
}
