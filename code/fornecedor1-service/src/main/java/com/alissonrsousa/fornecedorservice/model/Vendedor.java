package com.alissonrsousa.fornecedorservice.model;

import java.io.Serializable;

public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String cpf;

	private String nome;

	private String rg;

	public Vendedor() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}