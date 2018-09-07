package com.alissonrsousa.produtoservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.alissonrsousa.produtoservice.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
