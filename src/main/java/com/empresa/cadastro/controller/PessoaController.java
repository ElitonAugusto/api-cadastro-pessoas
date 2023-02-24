package com.empresa.cadastro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.cadastro.model.Pessoa;
import com.empresa.cadastro.services.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> obterTodos(){
        List<Pessoa> pessoas = pessoaService.obterTodos();

        return new ResponseEntity<>(pessoas , HttpStatus.OK);
    }

	@GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> obterPorId(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaService.obterPorId(id);
        return new ResponseEntity<>(Optional.of(pessoa.get()), HttpStatus.OK);
        
    }

    @PostMapping
    public ResponseEntity<Pessoa> adicionar (@RequestBody Pessoa pessoa){
        Pessoa pessoa1 = pessoaService.adicionar(pessoa);
        return new ResponseEntity<>(pessoa1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
         pessoaService.deletar(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pessoa> atualizar (@RequestBody Pessoa pessoa, @PathVariable Long id){
        Pessoa pessoa1 = pessoaService.atualizar(id, pessoa);
        return new ResponseEntity<>(pessoa1, HttpStatus.OK);
    }
    
    @PutMapping("/datanascimento/{id}")
    public ResponseEntity<Optional<Object>> atualizarDataNascimento(@PathVariable Long id, @RequestBody Pessoa novaPessoa) {
    	Optional<Object> pessoa1 = pessoaService.atualizarDataNascimento(id, novaPessoa);
    	return new ResponseEntity<>(pessoa1, HttpStatus.OK);
    }  
    
    @PutMapping("/nome/{id}")
    public ResponseEntity<Optional<Object>> atualizarNome(@PathVariable Long id, @RequestBody Pessoa novaPessoa) {
    	Optional<Object> pessoa1 = pessoaService.atualizarNome(id, novaPessoa);
    	return new ResponseEntity<>(pessoa1, HttpStatus.OK);
    }
}
