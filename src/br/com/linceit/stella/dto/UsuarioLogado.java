package br.com.linceit.stella.dto;

import br.com.linceit.stella.bean.TipoCadastro;

public class UsuarioLogado {
	
	private Integer identificador;
	private String nome;
	private TipoCadastro tipo;
	
	public UsuarioLogado(Integer identificador, String nome, TipoCadastro tipo) {
		super();
		this.identificador = identificador;
		this.nome = nome;
		this.tipo = tipo;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public String getNome() {
		return nome;
	}

	public TipoCadastro getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "UsuarioLogado [identificador=" + identificador + ", nome=" + nome + ", tipo=" + tipo + "]";
	}
	
	
}
