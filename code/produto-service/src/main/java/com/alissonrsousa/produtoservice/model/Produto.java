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
	private Double pesoLiquido;

	@Column(name="ponto_reposicao")
	private Integer pontoReposicao;

	@Column(name="preco_custo")
	private Double precoCusto;

	@Column(name="unidade")
	private String unidade;

	@Column(name="valor_unitario")
	private Double valorUnitario;

	@Column(name="volume")
	private Double volume;
	
	@Column(name="prazo_entrega")
	private Integer prazoEntrega;
	
	@Column(name="estoque")
	private Double estoque;

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

	public Double getPesoLiquido() {
		return this.pesoLiquido;
	}

	public void setPesoLiquido(Double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public Integer getPontoReposicao() {
		return this.pontoReposicao;
	}

	public void setPontoReposicao(Integer pontoReposicao) {
		this.pontoReposicao = pontoReposicao;
	}

	public Double getPrecoCusto() {
		return this.precoCusto;
	}

	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Double getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getVolume() {
		return this.volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(Integer prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public Double getEstoque() {
		return estoque;
	}

	public void setEstoque(Double estoque) {
		this.estoque = estoque;
	}

}