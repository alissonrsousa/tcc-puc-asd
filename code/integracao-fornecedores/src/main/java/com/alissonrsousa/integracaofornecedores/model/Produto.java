package com.alissonrsousa.integracaofornecedores.model;

import java.util.List;

public class Produto {
	
	private Long id;
	private String codigoBarras;
	private String descricao;
	private String imagem;
	private String marca;
	private String nome;
	private double pesoLiquido;
	private int pontoReposicao;
	private double precoCusto;
	private String unidade;
	private double valorUnitario;
	private double volume;
	private int prazoEntrega;
	private double estoque;
	private List<ProdutoFornecedor> produtos;

	public Produto() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return this.codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return this.imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPesoLiquido() {
		return this.pesoLiquido;
	}

	public void setPesoLiquido(double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public int getPontoReposicao() {
		return this.pontoReposicao;
	}

	public void setPontoReposicao(int pontoReposicao) {
		this.pontoReposicao = pontoReposicao;
	}

	public double getPrecoCusto() {
		return this.precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public double getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getVolume() {
		return this.volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public int getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public double getEstoque() {
		return estoque;
	}

	public void setEstoque(double estoque) {
		this.estoque = estoque;
	}

	public List<ProdutoFornecedor> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoFornecedor> produtos) {
		this.produtos = produtos;
	}

}