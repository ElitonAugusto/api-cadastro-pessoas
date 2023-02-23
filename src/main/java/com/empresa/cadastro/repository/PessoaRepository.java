package com.empresa.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.cadastro.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
