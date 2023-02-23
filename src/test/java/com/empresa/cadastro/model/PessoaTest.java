package com.empresa.cadastro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.empresa.cadastro.repository.PessoaRepository;

@SpringBootTest
public class PessoaTest {
	
	@Autowired
    private PessoaRepository pessoaRepository;

	@Test
    public void deve_salvar_pessoa_com_endereco() {
        Pessoa pessoa = new Pessoa("João","15/04/1980");
        Endereco endereco = new Endereco("Rua das Flores","85.985-897","145B",  "Florianopolis", null);
        endereco.setPessoa(pessoa);
        pessoa.setEnderecoPrincipal(endereco);
        pessoaRepository.save(pessoa);

        Optional<Pessoa> pessoaSalva = pessoaRepository.findById(pessoa.getId());
        assertTrue(pessoaSalva.isPresent());
        assertNotNull(pessoaSalva.get().getEnderecoPrincipal());
        assertEquals(endereco.getLogradouro(), pessoaSalva.get().getEnderecoPrincipal().getLogradouro());
        assertEquals(endereco.getCep(), pessoaSalva.get().getEnderecoPrincipal().getCep());
        assertEquals(endereco.getNumero(), pessoaSalva.get().getEnderecoPrincipal().getNumero());
        assertEquals(endereco.getCidade(), pessoaSalva.get().getEnderecoPrincipal().getCidade());
    }
	
	@Test
	public void testBuscarTodasPessoas() {
	    Pessoa pessoa1 = new Pessoa("João da Silva", "01/01/1990");
	    pessoaRepository.save(pessoa1);

	    Pessoa pessoa2 = new Pessoa("Maria dos Santos", "02/02/1991");
	    pessoaRepository.save(pessoa2);

	    List<Pessoa> pessoas = pessoaRepository.findAll();

	    assertEquals(2, pessoas.size());
	    assertTrue(pessoas.contains(pessoa1));
	    assertTrue(pessoas.contains(pessoa2));
	}
	 
	
}
