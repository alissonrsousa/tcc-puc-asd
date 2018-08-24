package com.alissonrsousa.segurancaservice.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alissonrsousa.segurancaservice.model.Usuario;
import com.alissonrsousa.segurancaservice.service.UsuarioService;

@RestController
@RequestMapping(value = "/seguranca/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
	
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Usuario> save(@RequestBody  Usuario Usuario){
        return ResponseEntity.ok(usuarioService.save(Usuario));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Usuario>> findAll(){
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
