package com.alissonrsousa.segurancaservice.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the funcao database table.
 * 
 */
@Entity
@Table(name="funcao")
@NamedQuery(name="Funcao.findAll", query="SELECT f FROM Funcao f")
public class Funcao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String link;

	private String nome;

	//bi-directional many-to-one association to Modulo
	@ManyToOne
	private Modulo modulo;

	public Funcao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

}