package com.alissonrsousa.segurancaservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo_usuario database table.
 * 
 */
@Entity
@Table(name="grupo_usuario")
@NamedQuery(name="GrupoUsuario.findAll", query="SELECT g FROM GrupoUsuario g")
public class GrupoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;

	//bi-directional many-to-many association to Modulo
	@ManyToMany
	@JoinTable(
		name="grupo_usuario_modulo"
		, joinColumns={
			@JoinColumn(name="grupo_usuario_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="modulo_id")
			}
		)
	private List<Modulo> modulos;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="grupoUsuarios")
	private List<Usuario> usuarios;

	public GrupoUsuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Modulo> getModulos() {
		return this.modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}