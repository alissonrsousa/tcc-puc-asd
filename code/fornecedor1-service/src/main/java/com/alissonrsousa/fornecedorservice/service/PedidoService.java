package com.alissonrsousa.fornecedorservice.service;

import java.util.List;
import com.alissonrsousa.fornecedorservice.model.Pedido;

public interface PedidoService {
	Pedido findById(Long id);
	List<Pedido> findAll();
}
