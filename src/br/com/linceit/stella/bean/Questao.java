package br.com.linceit.stella.bean;

public class Questao {
	private Integer cdQuestao;//CD_QUESTAO
	private String descricao;//DS_QUESTAO
	private String respostaA;//DS_A
	private String respostaB;//DS_B
	private String respostaC;//DS_C
	private String respostaD;//DS_D
	private String correta;//VL_ALTERNATIVA_CORRETA
	private Integer dificuldade = 1;//VL_DIFICULDADE
	
	public Questao() {}

	public Questao(Integer cdQuestao, String descricao, String respostaA, String respostaB, String respostaC,
			String respostaD, String correta, Integer dificuldade) {
		super();
		this.cdQuestao = cdQuestao;
		this.descricao = descricao;
		this.respostaA = respostaA;
		this.respostaB = respostaB;
		this.respostaC = respostaC;
		this.respostaD = respostaD;
		this.correta = correta;
		this.dificuldade = dificuldade;
	}

	public Questao(Integer cdQuestao) {
		this.cdQuestao = cdQuestao;
	}

	public Integer getCdQuestao() {
		return cdQuestao;
	}

	public void setCdQuestao(Integer cdQuestao) {
		this.cdQuestao = cdQuestao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getCorreta() {
		return correta;
	}

	public void setCorreta(String correta) {
		this.correta = correta;
	}

	public Integer getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Integer dificuldade) {
		this.dificuldade = dificuldade;
	}

	@Override
	public String toString() {
		return "Questao [cdQuestao=" + cdQuestao + ", descricao=" + descricao + ", respostaA=" + respostaA
				+ ", respostaB=" + respostaB + ", respostaC=" + respostaC + ", respostaD=" + respostaD + ", correta="
				+ correta + ", dificuldade=" + dificuldade + "]";
	}
	
	
}
