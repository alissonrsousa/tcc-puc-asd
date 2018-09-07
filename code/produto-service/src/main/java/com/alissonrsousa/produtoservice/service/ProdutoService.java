package com.alissonrsousa.produtoservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.alissonrsousa.produtoservice.model.Produto;
import com.alissonrsousa.produtoservice.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(@Validated Produto Produto) {
        return produtoRepository.save(Produto);
    }

    public Optional<Produto> findById(Long id){
        return produtoRepository.findById(id);
    }

    public Iterable<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
