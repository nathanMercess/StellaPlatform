package br.com.linceit.stella.bean;

import java.util.Date;

public class Disciplina {
	
	private Integer cdDisciplina;//CD_DISCIPLINA
	private Administrador administrador;//CD_ADM
	private String nome;//NM_DISCIPLINA
	private Date dtAbertura;//DT_ABERTURA
	private Date dtEncerramento;//DT_ENCERRAMENTO
	private boolean ativa;//VL_STATUS_ATIVA
	
	public Disciplina() {}
	
	public Disciplina(int cdDisciplina) {
		this.cdDisciplina = cdDisciplina; 
	}

	public Disciplina(Integer cdDisciplina, Administrador administrador, String nome, Date dtAbertura,
			Date dtEncerramento, boolean ativa) {
		super();
		this.cdDisciplina = cdDisciplina;
		this.administrador = administrador;
		this.nome = nome;
		this.dtAbertura = dtAbertura;
		this.dtEncerramento = dtEncerramento;
		this.ativa = ativa;
	}

	public Integer getCdDisciplina() {
		return cdDisciplina;
	}

	public void setCdDisciplina(Integer cdDisciplina) {
		this.cdDisciplina = cdDisciplina;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtEncerramento() {
		return dtEncerramento;
	}

	public void setDtEncerramento(Date dtEncerramento) {
		this.dtEncerramento = dtEncerramento;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	@Override
	public String toString() {
		return "Disciplina [cdDisciplina=" + cdDisciplina + ", administrador=" + administrador + ", nome=" + nome
				+ ", dtAbertura=" + dtAbertura + ", dtEncerramento=" + dtEncerramento + ", ativa=" + ativa + "]";
	}
	
	
}
