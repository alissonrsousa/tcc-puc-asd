package com.alissonrsousa.produtoservice.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProdutoPK id;

	@Column(name="codigo_barras")
	private String codigoBarras;

	private String descricao;

	private String imagem;

	private String marca;

	private String nome;

	@Column(name="peso_liquido")
	private double pesoLiquido;

	@Column(name="ponto_reposicao")
	private int pontoReposicao;

	@Column(name="preco_custo")
	private double precoCusto;

	private String unidade;

	@Column(name="valor_unitario")
	private double valorUnitario;

	private double volume;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoria_id", insertable=false, updatable=false)
	private Categoria categoria;

	public Produto() {
	}

	public ProdutoPK getId() {
		return this.id;
	}

	public void setId(ProdutoPK id) {
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

}