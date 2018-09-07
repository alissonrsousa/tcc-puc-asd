package com.alissonrsousa.fornecedorservice.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alissonrsousa.fornecedorservice.model.Pedido;
import com.alissonrsousa.fornecedorservice.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {
	
    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pedido>> findAll(){
        return ResponseEntity.ok().body(pedidoService.findAll());
    }

}
