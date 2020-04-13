package br.com.linceit.stella.dto;

public class DisciplinaComStatusMatricula {
	
	private String nomeDisciplina;
	private Integer cdDisciplina;
	private Integer cdMatricula;
	private Boolean ativa;
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public Integer getCdDisciplina() {
		return cdDisciplina;
	}
	public void setCdDisciplina(Integer cdDisciplina) {
		this.cdDisciplina = cdDisciplina;
	}
	public Integer getCdMatricula() {
		return cdMatricula == null ? 0 : cdMatricula;
	}
	
	public void setCdMatricula(Integer cdMatricula) {
		this.cdMatricula = cdMatricula;
	}
	public Boolean getAtiva() {
		return ativa == null ? false : ativa;
	}
	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}
}
