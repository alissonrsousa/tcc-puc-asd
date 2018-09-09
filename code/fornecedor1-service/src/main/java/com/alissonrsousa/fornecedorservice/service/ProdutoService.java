package com.alissonrsousa.fornecedorservice.service;

import java.util.List;
import com.alissonrsousa.fornecedorservice.model.Produto;

public interface ProdutoService {
	Produto findById(Long id);
	List<Produto> findAll();
	List<Produto> findByIdIn(List<Long> listaIds);
}
