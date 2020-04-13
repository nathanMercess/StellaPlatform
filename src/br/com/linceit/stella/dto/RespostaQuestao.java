package br.com.linceit.stella.dto;

public class RespostaQuestao {
	
	private Integer cdQuestao;
	
	private String resposta;

	public Integer getCdQuestao() {
		return cdQuestao;
	}

	public void setCdQuestao(Integer cdQuestao) {
		this.cdQuestao = cdQuestao;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	@Override
	public String toString() {
		return "RespostaQuestao [cdQuestao=" + cdQuestao + ", resposta=" + resposta + "]";
	}
	
	
	
}
