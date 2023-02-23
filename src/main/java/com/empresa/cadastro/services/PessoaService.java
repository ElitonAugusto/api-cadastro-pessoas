package com.empresa.cadastro.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.cadastro.model.Pessoa;
import com.empresa.cadastro.repository.PessoaRepository;
import com.empresa.cadastro.shared.PessoaDTO;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public List<PessoaDTO> obterTodos(){
		List<Pessoa> pessoas = pessoaRepository.findAll();
		
		return pessoas.stream()
		.map(pessoa -> new ModelMapper().map(pessoa, PessoaDTO.class))
		.collect(Collectors.toList());
	}

}
