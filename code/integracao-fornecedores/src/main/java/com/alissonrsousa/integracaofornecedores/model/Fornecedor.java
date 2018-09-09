package com.alissonrsousa.integracaofornecedores.model;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {

	private Integer id;
	private String bairro;
	private String cep;
	private String cidade;
	private String cnpj;
	private String complemento;
	private String contato;
	private String cpf;
	private String email;
	private String endereco;
	private String urlIntegracao;
	private String usuarioIntegracao;
	private String senhaIntegracao;
	private String urlOauthIntegracao;
	private Integer enderecoId;
	private String estado;
	private String funcaoContato;
	private String nomeFantasia;
	private String numero;
	private String razaoSocial;
	private String telafone1;
	private String telefone2;
	private Integer usuarioId;
	private List<ProdutoFornecedor> produtos;

	public Fornecedor() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getEnderecoId() {
		return this.enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFuncaoContato() {
		return this.funcaoContato;
	}

	public void setFuncaoContato(String funcaoContato) {
		this.funcaoContato = funcaoContato;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelafone1() {
		return this.telafone1;
	}

	public void setTelafone1(String telafone1) {
		this.telafone1 = telafone1;
	}

	public String getTelefone2() {
		return this.telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public Integer getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUrlIntegracao() {
		return urlIntegracao;
	}

	public void setUrlIntegracao(String urlIntegracao) {
		this.urlIntegracao = urlIntegracao;
	}

	public String getUsuarioIntegracao() {
		return usuarioIntegracao;
	}

	public void setUsuarioIntegracao(String usuarioIntegracao) {
		this.usuarioIntegracao = usuarioIntegracao;
	}

	public String getSenhaIntegracao() {
		return senhaIntegracao;
	}

	public void setSenhaIntegracao(String senhaIntegracao) {
		this.senhaIntegracao = senhaIntegracao;
	}

	public String getUrlOauthIntegracao() {
		return urlOauthIntegracao;
	}

	public void setUrlOauthIntegracao(String urlOauthIntegracao) {
		this.urlOauthIntegracao = urlOauthIntegracao;
	}

	public List<ProdutoFornecedor> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoFornecedor> produtos) {
		this.produtos = produtos;
	}
	
	public List<Long> getIdsProdutosFornecedor() {
		List<Long> ids = new ArrayList<Long>();
		for (ProdutoFornecedor produto: produtos) {
			ids.add(produto.getIdProdutoFornecedor());
		}
		return ids;
	}

}