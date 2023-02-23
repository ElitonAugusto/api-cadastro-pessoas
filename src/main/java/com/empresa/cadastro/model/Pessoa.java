package com.empresa.cadastro.model;

import java.util.List;

public class Pessoa {
	
    private Long id;
    private String nome;
    private String dataNascimento;

    private List<Endereco> enderecos;

    private Endereco enderecoPrincipal;
    
	public Pessoa() {
	}

	public Pessoa(String nome, String dataNascimento, List<Endereco> enderecos, Endereco enderecoPrincipal) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
		this.enderecoPrincipal = enderecoPrincipal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco getEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(Endereco enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}
}