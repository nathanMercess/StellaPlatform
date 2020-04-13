package br.com.linceit.stella.bean;

import java.util.Date;

public class Administrador {

	private Integer cdAdmin; // CD_ADM
	private String nome; // NM_ADMINISTRADOR
	private String email; // DS_EMAIL
	private String senha; // DS_SENHA
	private String cdRecuperaco; // CD_RECUPERACAO
	private Date dtRecuperacao; // DT_RECUPERACAO
	private Boolean ultimoCodigoUtilizado; // VL_UTILIZADO
	
	public Administrador() {}
	
	public Administrador(Integer cdAdmin, String nome, String email, String senha, String cdRecuperaco,
			Date dtRecuperacao, Boolean ultimoCodigoUtilizado) {
		super();
		this.cdAdmin = cdAdmin;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cdRecuperaco = cdRecuperaco;
		this.dtRecuperacao = dtRecuperacao;
		this.ultimoCodigoUtilizado = ultimoCodigoUtilizado;
	}
	
	public Administrador(Integer cdAdmin, String nome) {
		this.cdAdmin = cdAdmin;
		this.nome = nome;
	}
	
	public Integer getCdAdmin() {
		return cdAdmin;
	}

	public void setCdAdmin(Integer cdAdmin) {
		this.cdAdmin = cdAdmin;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCdRecuperaco() {
		return cdRecuperaco;
	}

	public void setCdRecuperaco(String cdRecuperaco) {
		this.cdRecuperaco = cdRecuperaco;
	}

	public Date getDtRecuperacao() {
		return dtRecuperacao;
	}

	public void setDtRecuperacao(Date dtRecuperacao) {
		this.dtRecuperacao = dtRecuperacao;
	}

	public Boolean getUltimoCodigoUtilizado() {
		return ultimoCodigoUtilizado;
	}

	public void setUltimoCodigoUtilizado(Boolean ultimoCodigoUtilizado) {
		this.ultimoCodigoUtilizado = ultimoCodigoUtilizado;
	}

}
