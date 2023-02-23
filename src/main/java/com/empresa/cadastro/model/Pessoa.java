package com.empresa.cadastro.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pessoa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idPessoa")
    private Long id;
    private String nome;
    private String dataNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco enderecoPrincipal;

	public Pessoa() {
	}

	public Pessoa(String nome, String dataNascimento, List<Endereco> enderecos, Endereco enderecoPrincipal) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
		this.enderecoPrincipal = enderecoPrincipal;
	}

	public Pessoa(String nome, String dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, enderecoPrincipal, enderecos, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(enderecoPrincipal, other.enderecoPrincipal)
				&& Objects.equals(enderecos, other.enderecos) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
}