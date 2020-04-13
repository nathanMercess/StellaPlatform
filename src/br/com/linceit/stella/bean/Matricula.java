package br.com.linceit.stella.bean;

import java.util.Date;

public class Matricula {
	
	private Integer cdMatricula;//CD_MATRICULA
	private Aluno aluno;//CD_RM
	private Disciplina disciplina;//CD_DISCIPLINA
	private Date dtMatricula;//DT_MATRICULA
	private boolean aberta;//ST_SITUACAO
	
	public Matricula() {}
	
	public Matricula(Integer cdMatricula) {
		this.cdMatricula = cdMatricula;
	}
	
	public Matricula(Aluno aluno, Disciplina disciplina) {
		this.aluno = aluno;
		this.disciplina = disciplina;
	}
		
	public Matricula(Integer cdMatricula, Aluno aluno, Disciplina disciplina, Date dtMatricula, boolean aberta) {
		super();
		this.cdMatricula = cdMatricula;
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.dtMatricula = dtMatricula;
		this.aberta = aberta;
	}
	
	public Integer getCdMatricula() {
		return cdMatricula;
	}

	public void setCdMatricula(Integer cdMatricula) {
		this.cdMatricula = cdMatricula;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Date getDtMatricula() {
		return dtMatricula;
	}

	public void setDtMatricula(Date dtMatricula) {
		this.dtMatricula = dtMatricula;
	}

	public boolean isAberta() {
		return aberta;
	}

	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}
	
	
}
