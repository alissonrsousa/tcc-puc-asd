package com.alissonrsousa.produtoservice.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alissonrsousa.produtoservice.model.Fornecedor;
import com.alissonrsousa.produtoservice.model.ProdutoFornecedor;
import com.alissonrsousa.produtoservice.service.FornecedorService;
import com.alissonrsousa.produtoservice.service.ProdutoFornecedorService;

@RestController
@RequestMapping(value = "/produto/fornecedores", produces = MediaType.APPLICATION_JSON_VALUE)
public class FornecedorController {
	
    @Autowired
    private FornecedorService FornecedorService;
    
    @Autowired
    private ProdutoFornecedorService produtoFornecedorService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Fornecedor> save(@RequestBody  Fornecedor fornecedor){
        return ResponseEntity.ok(FornecedorService.save(fornecedor));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Fornecedor>> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(FornecedorService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Fornecedor>> findAll(){
        return ResponseEntity.ok().body(FornecedorService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        FornecedorService.delete(id);
        return ResponseEntity.ok().build();
    }
    
    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public ResponseEntity<?> saveProdutos(@RequestBody List<ProdutoFornecedor> produtos){
        produtoFornecedorService.save(produtos);
        return ResponseEntity.ok().build();
    }
}
