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

import com.empresa.cadastro.model.Endereco;
import com.empresa.cadastro.services.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> obterTodos(){
        List<Endereco> enderecos = enderecoService.obterTodos();

        return new ResponseEntity<>(enderecos , HttpStatus.OK);
    }

	@GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> obterPorId(@PathVariable Long id){
        Optional<Endereco> endereco1 = enderecoService.obterPorId(id);
        return new ResponseEntity<>(Optional.of(endereco1.get()), HttpStatus.OK);
        
    }

    @PostMapping
    public ResponseEntity<Endereco> adicionar (@RequestBody Endereco endereco){
        Endereco endereco1 = enderecoService.adicionar(endereco);
        return new ResponseEntity<>(endereco1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
         enderecoService.deletar(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 

    @PutMapping("{id}")
    public ResponseEntity<Endereco> atualizar (@RequestBody Endereco endereco, @PathVariable Long id){
        Endereco endereco1 = enderecoService.atualizar(id, endereco);
        return new ResponseEntity<>(endereco1, HttpStatus.OK);
    }
    
    @PutMapping("/principal/{id}")
    public ResponseEntity<Optional<Object>> indicarEnderecoPrincipal(@PathVariable Long id, @RequestBody Endereco novoEndereco) {
    	Optional<Object> endereco1 = enderecoService.indicarEnderecoPrincipal(id, novoEndereco);
    	return new ResponseEntity<>(endereco1, HttpStatus.OK);
    }
}
