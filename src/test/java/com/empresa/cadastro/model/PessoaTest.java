package com.empresa.cadastro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        Pessoa pessoa = new Pessoa("João","15/04/1980",null);
        Endereco endereco = new Endereco("Endereço principal","Rua das Flores","85.985-897","145B",  "Florianopolis", null);
        endereco.setPessoa(pessoa);
        pessoa.getEnderecos().add(endereco);
        pessoaRepository.save(pessoa);

        Optional<Pessoa> pessoaSalva = pessoaRepository.findById(pessoa.getId());
        
        assertTrue(pessoaSalva.isPresent());
        assertNotNull(pessoaSalva.get().getEnderecos());
        assertEquals(endereco.getLogradouro(), pessoaSalva.get().getEnderecos().get(0).getLogradouro());
        assertEquals(endereco.getCep(), pessoaSalva.get().getEnderecos().get(0).getCep());
        assertEquals(endereco.getNumero(), pessoaSalva.get().getEnderecos().get(1).getNumero());
        assertEquals(endereco.getCidade(), pessoaSalva.get().getEnderecos().get(1).getCidade());
    }
	
	@Test
	public void testBuscarTodasPessoas() {
	    Pessoa pessoa1 = new Pessoa("Fatima Bernardes", "26/11/1997",null);
	    pessoaRepository.save(pessoa1);

	    Pessoa pessoa2 = new Pessoa("Maria Tereza", "27/02/1985",null);
	    pessoaRepository.save(pessoa2);

	    List<Pessoa> pessoas = pessoaRepository.findAll();

	    assertEquals(2, pessoas.size());
	    assertTrue(pessoas.contains(pessoa1));
	    assertTrue(pessoas.contains(pessoa2));
	}
}
