package com.alissonrsousa.fornecedorservice.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alissonrsousa.fornecedorservice.model.Produto;
import com.alissonrsousa.fornecedorservice.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {
	
    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Produto>> findAll(){
        return ResponseEntity.ok().body(produtoService.findAll());
    }

}
