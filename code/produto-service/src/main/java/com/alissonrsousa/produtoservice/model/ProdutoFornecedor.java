package com.alissonrsousa.produtoservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="produto_fornecedor")
@NamedQuery(name="ProdutoFornecedor.findAll", query="SELECT p FROM ProdutoFornecedor p")
public class ProdutoFornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	@Transient
	private Integer idFornecedor;
	
	@Column(name="id_produto_fornecedor")
	private Long idProdutoFornecedor;
	
	@Column(name="preco")
	private Double preco;
	
	@Column(name="prazo_entrega")
	private int prazoEntrega;
	
	@Column(name="valor_frete")
	private Double valorFrete;
	
	@Column(name="estoque")
	private Double estoque;
	
	@Column(name="data_atualizacao")
	private Date dataAtualizacao;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getIdProdutoFornecedor() {
		return idProdutoFornecedor;
	}

	public void setIdProdutoFornecedor(Long idProdutoFornecedor) {
		this.idProdutoFornecedor = idProdutoFornecedor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public Double getEstoque() {
		return estoque;
	}

	public void setEstoque(Double estoque) {
		this.estoque = estoque;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
	public String getNomeProduto() {
		return produto.getNome();
	}

}