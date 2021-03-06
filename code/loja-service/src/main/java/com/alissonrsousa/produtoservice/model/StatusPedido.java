package com.alissonrsousa.produtoservice.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the status_pedido database table.
 * 
 */
@Entity
@Table(name="status_pedido")
@NamedQuery(name="StatusPedido.findAll", query="SELECT s FROM StatusPedido s")
public class StatusPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descricao;

	public StatusPedido() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}