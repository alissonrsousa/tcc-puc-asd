package com.alissonrsousa.produtoservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.alissonrsousa.produtoservice.model.Fornecedor;
import com.alissonrsousa.produtoservice.repository.FornecedorRepository;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository FornecedorRepository;

    public Fornecedor save(@Validated Fornecedor fornecedor) {
        return FornecedorRepository.save(fornecedor);
    }

    public Optional<Fornecedor> findById(Integer id){
        return FornecedorRepository.findById(id);
    }

    public Iterable<Fornecedor> findAll(){
        return FornecedorRepository.findAll();
    }

    public void delete(Integer id) {
        FornecedorRepository.deleteById(id);
    }
}
