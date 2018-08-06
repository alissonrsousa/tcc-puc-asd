package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status_usuario database table.
 * 
 */
@Entity
@Table(name="status_usuario")
@NamedQuery(name="StatusUsuario.findAll", query="SELECT s FROM StatusUsuario s")
public class StatusUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descricao;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="statusUsuario")
	private List<Usuario> usuarios;

	public StatusUsuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setStatusUsuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setStatusUsuario(null);

		return usuario;
	}

}