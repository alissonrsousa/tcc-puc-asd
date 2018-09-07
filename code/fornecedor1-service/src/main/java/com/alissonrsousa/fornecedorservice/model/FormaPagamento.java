package com.alissonrsousa.fornecedorservice.model;

import java.io.Serializable;

public class FormaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String descricao;

	public FormaPagamento() {
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