package com.alissonrsousa.produtoservice.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alissonrsousa.produtoservice.model.Produto;
import com.alissonrsousa.produtoservice.service.ProdutoService;

@RestController
@RequestMapping(value = "/produto/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {
	
    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Produto> save(@RequestBody  Produto Produto){
        return ResponseEntity.ok(produtoService.save(Produto));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Produto>> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Produto>> findAll(){
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
