package com.alissonrsousa.fornecedorservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alissonrsousa.fornecedorservice.model.Produto;
import com.alissonrsousa.fornecedorservice.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	static {
		initProdutos();
	}
	
	private static List<Produto> produtos;

	@Override
	public Produto findById(Long id) {
		return produtos.get(id.intValue());
	}

	@Override
	public List<Produto> findAll() {
		return produtos;
	}
	
	private static void initProdutos() {
		produtos = new ArrayList<>();
		for (long i=0; i<100; i++) {
			Produto produto = new Produto();
			produto.setId(i);
			produto.setNome("Produto " + i);
			produto.setPesoLiquido(i*10);
			produto.setUnidade("un");
			produto.setPreco(5+i);
			produto.setPrazoEntrega(7+1);
			produto.setValorFrete(8+i);
			produto.setEstoque(i*30);
			produtos.add(produto);
		}
	}

}
