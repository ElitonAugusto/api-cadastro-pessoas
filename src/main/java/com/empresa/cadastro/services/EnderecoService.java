package com.empresa.cadastro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.cadastro.model.Endereco;
import com.empresa.cadastro.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	public List<Endereco> obterTodos() {
		return enderecoRepository.findAll();
	}

	public Optional<Endereco> obterPorId(Long id) {

		Optional<Endereco> endereco = enderecoRepository.findById(id);

		if (endereco.isEmpty()) {
			throw new RuntimeException("Pessoa com id: " + id + " Não encontrado.");
		}

		return endereco;
	}

	public Endereco adicionar(Endereco edereco) {

		edereco.setId(null);
		
		return enderecoRepository.save(edereco);
	}

	public void deletar(Long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);

		if (endereco.isEmpty()) {
			throw new RuntimeException("Endereco do id: " + id + " Não encontrado. Não foi deletado!");
		}

		enderecoRepository.deleteById(id);
	}

	public Endereco atualizar(Long id, Endereco endereco) {
		endereco.setId(id);

		return enderecoRepository.save(endereco);
	}
	
	public Optional<Object> indicarEnderecoPrincipal(Long id, Endereco novoEndereco) {
		return enderecoRepository.findById(id).map(endereco -> {
			endereco.setObservacao(novoEndereco.getObservacao());
			return enderecoRepository.save(endereco);
		});
	}
}
