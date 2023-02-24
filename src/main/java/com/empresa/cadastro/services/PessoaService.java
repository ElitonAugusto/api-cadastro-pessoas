package com.empresa.cadastro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.cadastro.model.Pessoa;
import com.empresa.cadastro.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	public List<Pessoa> obterTodos() {
		return pessoaRepository.findAll();
	}

	public Optional<Pessoa> obterPorId(Long id) {

		Optional<Pessoa> pessoa = pessoaRepository.findById(id);

		if (pessoa.isEmpty()) {
			throw new RuntimeException("Pessoa com id: " + id + " Não encontrado.");
		}
		return pessoa;
	}

	public Pessoa adicionar(Pessoa pessoa) {

		pessoa.setId(null);
		return pessoaRepository.save(pessoa);
	}

	public void deletar(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);

		if (pessoa.isEmpty()) {
			throw new RuntimeException("Pessoa do id: " + id + " Não encontrada. Não foi deletado!");
		}

		pessoaRepository.deleteById(id);
	}

	public Pessoa atualizar(Long id, Pessoa pessoa) {
		pessoa.setId(id);
		pessoaRepository.save(pessoa);
		return pessoa;
	}

	public Optional<Object> atualizarDataNascimento(Long id, Pessoa novaPessoa) {
		return pessoaRepository.findById(id).map(pessoa -> {
			pessoa.setDataNascimento(novaPessoa.getDataNascimento());
			return pessoaRepository.save(pessoa);
		});
	}

	public Optional<Object> atualizarNome(Long id, Pessoa novaPessoa) {
		return pessoaRepository.findById(id).map(pessoa -> {
			pessoa.setNome(novaPessoa.getNome());
			return pessoaRepository.save(pessoa);
		});
	}
}
