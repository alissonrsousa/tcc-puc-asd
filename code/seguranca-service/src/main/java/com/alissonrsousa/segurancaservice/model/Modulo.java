package com.alissonrsousa.segurancaservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modulo database table.
 * 
 */
@Entity
@Table(name="modulo")
@NamedQuery(name="Modulo.findAll", query="SELECT m FROM Modulo m")
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String link;

	private String nome;

	//bi-directional many-to-one association to Funcao
	@OneToMany(mappedBy="modulo")
	private List<Funcao> funcaos;

	//bi-directional many-to-many association to GrupoUsuario
	@ManyToMany(mappedBy="modulos")
	private List<GrupoUsuario> grupoUsuarios;

	public Modulo() {
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

	public List<Funcao> getFuncaos() {
		return this.funcaos;
	}

	public void setFuncaos(List<Funcao> funcaos) {
		this.funcaos = funcaos;
	}

	public Funcao addFuncao(Funcao funcao) {
		getFuncaos().add(funcao);
		funcao.setModulo(this);

		return funcao;
	}

	public Funcao removeFuncao(Funcao funcao) {
		getFuncaos().remove(funcao);
		funcao.setModulo(null);

		return funcao;
	}

	public List<GrupoUsuario> getGrupoUsuarios() {
		return this.grupoUsuarios;
	}

	public void setGrupoUsuarios(List<GrupoUsuario> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

}