package com.alissonrsousa.produtoservice.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="produto")
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long id;

	@Column(name="codigo_barras")
	private String codigoBarras;

	@Column(name="descricao")
	private String descricao;

	@Column(name="imagem")
	private String imagem;

	@Column(name="marca")
	private String marca;

	@Column(name="nome")
	private String nome;

	@Column(name="peso_liquido")
	private double pesoLiquido;

	@Column(name="ponto_reposicao")
	private int pontoReposicao;

	@Column(name="preco_custo")
	private double precoCusto;

	@Column(name="unidade")
	private String unidade;

	@Column(name="valor_unitario")
	private double valorUnitario;

	@Column(name="volume")
	private double volume;
	
	@Column(name="prazo_entrega")
	private int prazoEntrega;
	
	@Column(name="estoque")
	private double estoque;

	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;

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

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

}