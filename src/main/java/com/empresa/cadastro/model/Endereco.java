package com.empresa.cadastro.model;

public class Endereco {
	
	private Long id;
	private String logadouro;
	private String cep;
	private String cidade;
	private String numero;
	
	private Pessoa pessoa;
	
	public Endereco() {
	}

	public Endereco(String logadouro, String cep, String cidade, String numero, Pessoa pessoa) {
		this.logadouro = logadouro;
		this.cep = cep;
		this.cidade = cidade;
		this.numero = numero;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogadouro() {
		return logadouro;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}