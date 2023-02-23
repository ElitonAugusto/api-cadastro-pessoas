package com.empresa.cadastro.shared;

import java.util.List;

public class PessoaDTO {
	
    private Long id;
    private String nome;
    private String dataNascimento;

    private List<EnderecoDTO> enderecos;

    private EnderecoDTO enderecoPrincipal;
    
	public PessoaDTO() {
	}

	public PessoaDTO(String nome, String dataNascimento, List<EnderecoDTO> enderecos, EnderecoDTO enderecoPrincipal) {
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

	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}

	public EnderecoDTO getEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(EnderecoDTO enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}
}
