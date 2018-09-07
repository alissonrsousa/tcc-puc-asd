package com.alissonrsousa.produtoservice.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alissonrsousa.produtoservice.model.Vendedor;
import com.alissonrsousa.produtoservice.service.VendedorService;

@RestController
@RequestMapping(value = "/loja/vendedor", produces = MediaType.APPLICATION_JSON_VALUE)
public class VendedorController {
	
    @Autowired
    private VendedorService VendedorService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Vendedor> save(@RequestBody  Vendedor Vendedor){
        return ResponseEntity.ok(VendedorService.save(Vendedor));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Vendedor>> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(VendedorService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Vendedor>> findAll(){
        return ResponseEntity.ok().body(VendedorService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        VendedorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
