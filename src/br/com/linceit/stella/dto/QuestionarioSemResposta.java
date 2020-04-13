package br.com.linceit.stella.dto;

public class QuestionarioSemResposta {

	private Integer cdQuestao;
	private Integer cdAvaliacao;
	private String pergunta;
	private String respostaA;
	private String respostaB;
	private String respostaC;
	private String respostaD;
	private String respostaAluno = "";
	
	public Integer getCdQuestao() {
		return cdQuestao;
	}

	public void setCdQuestao(Integer cdQuestao) {
		this.cdQuestao = cdQuestao;
	}

	public Integer getCdAvaliacao() {
		return cdAvaliacao;
	}

	public void setCdAvaliacao(Integer cdAvaliacao) {
		this.cdAvaliacao = cdAvaliacao;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getRespostaA() {
		return respostaA;
	}

	public void setRespostaA(String respostaA) {
		this.respostaA = respostaA;
	}

	public String getRespostaB() {
		return respostaB;
	}

	public void setRespostaB(String respostaB) {
		this.respostaB = respostaB;
	}

	public String getRespostaC() {
		return respostaC;
	}

	public void setRespostaC(String respostaC) {
		this.respostaC = respostaC;
	}

	public String getRespostaD() {
		return respostaD;
	}

	public void setRespostaD(String respostaD) {
		this.respostaD = respostaD;
	}

	public String getRespostaAluno() {
		return respostaAluno;
	}

	public void setRespostaAluno(String respostaAluno) {
		this.respostaAluno = respostaAluno;
	}

}
