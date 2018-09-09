package com.alissonrsousa.fornecedorservice.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    
    @RequestMapping(value = "/idsIn/{ids}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Produto>> findByIds(@PathVariable("ids") String ids){
    	String[] array = ids.split(",");
    	List<Long> listaIds = new ArrayList<>();
    	for (String id: array) {
    		listaIds.add(Long.valueOf(id));
    	}
        return ResponseEntity.ok().body(produtoService.findByIdIn(listaIds));
    }

}
