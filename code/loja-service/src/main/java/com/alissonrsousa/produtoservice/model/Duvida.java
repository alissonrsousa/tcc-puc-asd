package com.alissonrsousa.produtoservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the duvida database table.
 * 
 */
@Entity
@Table(name="duvida")
@NamedQuery(name="Duvida.findAll", query="SELECT d FROM Duvida d")
public class Duvida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro")
	private Date dataCadastro;

	private String pergunta;

	@Column(name="qde_acesso")
	private int qdeAcesso;

	private String resposta;

	public Duvida() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getPergunta() {
		return this.pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public int getQdeAcesso() {
		return this.qdeAcesso;
	}

	public void setQdeAcesso(int qdeAcesso) {
		this.qdeAcesso = qdeAcesso;
	}

	public String getResposta() {
		return this.resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

}