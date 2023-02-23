package com.empresa.cadastro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idEndereço")
	private Long id;
	private String logradouro;
	private String cep;
	private String cidade;
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "idDaPessoa")
	private Pessoa pessoa;
	
	public Endereco() {
	}

	public Endereco(String logadouro, String cep, String cidade, String numero, Pessoa pessoa) {
		this.logradouro = logadouro;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logadouro) {
		this.logradouro = logadouro;
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