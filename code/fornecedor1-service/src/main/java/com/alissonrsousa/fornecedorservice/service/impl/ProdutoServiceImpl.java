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
		initProdutos();
		return produtos;
	}
	
	private static void initProdutos() {
		double randon = Math.random();
		produtos = new ArrayList<>();
		for (long i=0; i<100; i++) {
			Produto produto = new Produto();
			produto.setId(i);
			produto.setNome("Produto " + i);
			produto.setPesoLiquido(i*10*(randon*10));
			produto.setUnidade("un");
			produto.setValorUnitario(5+i+(randon*10));
			produto.setPrazoEntrega(new Double((7+i)*(randon*10)).intValue());
			produto.setValorFrete((8+i)*(randon*10));
			produto.setEstoque((i*30)*(randon*10));
			produtos.add(produto);
		}
	}

	@Override
	public List<Produto> findByIdIn(List<Long> listaIds) {
		initProdutos();
		List<Produto> lista = new ArrayList<>();
		for (Produto produto: produtos) {
			if (listaIds.contains(produto.getId())) {
				lista.add(produto);
			}
		}
		return lista;
	}

}
