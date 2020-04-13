package br.com.linceit.stella.bean;

public class QuestionarioRespondido {
	
	private Matricula matricula;//CD_MATRICULA
	private Avaliacao avaliacao;//CD_AVALIACAO
	private Questao questao;//CD_QUESTAO
	private String respostaCorreta;//VL_RESPOSTA_CORRETA
	private String respostaAluno;//VL_RESPOSTA_ALUNO
	
	public QuestionarioRespondido() {}
	
	public QuestionarioRespondido(Matricula matricula, Avaliacao avaliacao, Questao questao, String respostaCorreta,
			String respostaAluno) {
		super();
		this.matricula = matricula;
		this.avaliacao = avaliacao;
		this.questao = questao;
		this.respostaCorreta = respostaCorreta;
		this.respostaAluno = respostaAluno;
	}



	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
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
	public String getRespostaCorreta() {
		return respostaCorreta;
	}
	public void setRespostaCorreta(String respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}
	public String getRespostaAluno() {
		return respostaAluno;
	}
	public void setRespostaAluno(String respostaAluno) {
		this.respostaAluno = respostaAluno;
	}
	
	
	
}
