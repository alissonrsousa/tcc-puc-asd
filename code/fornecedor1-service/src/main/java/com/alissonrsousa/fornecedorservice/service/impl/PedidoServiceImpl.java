package com.alissonrsousa.fornecedorservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alissonrsousa.fornecedorservice.model.Pedido;
import com.alissonrsousa.fornecedorservice.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	static {
		initPedidos();
	}
	
	private static List<Pedido> pedidos;

	@Override
	public Pedido findById(Long id) {
		return pedidos.get(id.intValue());
	}

	@Override
	public List<Pedido> findAll() {
		return pedidos;
	}
	
	private static void initPedidos() {
		pedidos = new ArrayList<>();
		for (long i=0; i<100; i++) {
			Pedido Pedido = new Pedido();
			Pedido.setId(i);
			pedidos.add(Pedido);
		}
	}

}
