package com.alissonrsousa.produtoservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.alissonrsousa.produtoservice.model.Vendedor;
import com.alissonrsousa.produtoservice.repository.VendedorRepository;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository VendedorRepository;

    public Vendedor save(@Validated Vendedor Vendedor) {
        return VendedorRepository.save(Vendedor);
    }

    public Optional<Vendedor> findById(Long id){
        return VendedorRepository.findById(id);
    }

    public Iterable<Vendedor> findAll(){
        return VendedorRepository.findAll();
    }

    public void delete(Long id) {
        VendedorRepository.deleteById(id);
    }
}
