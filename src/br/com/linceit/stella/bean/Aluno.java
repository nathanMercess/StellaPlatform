package br.com.linceit.stella.bean;

import java.util.Date;

public class Aluno {
	
	private Integer rm;//CD_RM
	private String nome;///NM_ALUNO
	private String senha;//DS_SENHA
	private String email;//DS_EMAIL
	private Date dtNascimento = new Date(0l);//DT_NASC
	private String endereco;//DS_ENDERECO
	private Integer telefone = null;//NR_TELEFONE
	private String cdRecuperacao = "SEM_CODIGO";//CD_RECUPERACAO
	private Date dtCriacao = new Date(0l);//DT_CRIACAO
	private boolean cdRecuperacaoUtilizado;//VL_UTILIZADO
	
	public Aluno() {}
	
	public Aluno(Integer rm, String nome) {
		this.rm = rm;
		this.nome = nome;
	}
	
	public Aluno(Integer rm, String nome, String senha, String email, Date dtNascimento, String endereco,
			Integer telefone, String cdRecuperacao, Date dtCriacao, boolean cdRecuperacaoUtilizado) {
		super();
		this.rm = rm;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.dtNascimento = dtNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cdRecuperacao = cdRecuperacao;
		this.dtCriacao = dtCriacao;
		this.cdRecuperacaoUtilizado = cdRecuperacaoUtilizado;
	}

	public Aluno(Integer cdAluno) {
		this.rm = cdAluno;
	}

	public Integer getRm() {
		return rm;
	}

	public void setRm(Integer rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getCdRecuperacao() {
		return cdRecuperacao;
	}

	public void setCdRecuperacao(String cdRecuperacao) {
		this.cdRecuperacao = cdRecuperacao;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}
	
	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public boolean isCdRecuperacaoUtilizado() {
		return cdRecuperacaoUtilizado;
	}

	public void setCdRecuperacaoUtilizado(boolean cdRecuperacaoUtilizado) {
		this.cdRecuperacaoUtilizado = cdRecuperacaoUtilizado;
	}

	@Override
	public String toString() {
		return "Aluno [rm=" + rm + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", dtNascimento="
				+ dtNascimento + ", endereco=" + endereco + ", telefone=" + telefone + ", cdRecuperacao="
				+ cdRecuperacao + ", dtCriacao=" + dtCriacao + ", cdRecuperacaoUtilizado=" + cdRecuperacaoUtilizado
				+ "]";
	}
	
	
}
