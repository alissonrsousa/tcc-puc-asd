package com.alissonrsousa.segurancaservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.alissonrsousa.segurancaservice.model.Usuario;
import com.alissonrsousa.segurancaservice.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(@Validated Usuario Usuario) {
        return usuarioRepository.save(Usuario);
    }

    public Optional<Usuario> findById(Integer id){
        return usuarioRepository.findById(id);
    }

    public Iterable<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
