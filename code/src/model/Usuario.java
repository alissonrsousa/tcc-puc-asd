package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioPK id;

	private String login;

	private String senha;

	//bi-directional many-to-one association to StatusUsuario
	@ManyToOne
	@JoinColumn(name="status_usuario_id")
	private StatusUsuario statusUsuario;

	//bi-directional many-to-many association to GrupoUsuario
	@ManyToMany
	@JoinTable(
		name="usuario_grupo_usuario"
		, joinColumns={
			@JoinColumn(name="usuario_id", referencedColumnName="id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="grupo_usuario_id")
			}
		)
	private List<GrupoUsuario> grupoUsuarios;

	public Usuario() {
	}

	public UsuarioPK getId() {
		return this.id;
	}

	public void setId(UsuarioPK id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public StatusUsuario getStatusUsuario() {
		return this.statusUsuario;
	}

	public void setStatusUsuario(StatusUsuario statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public List<GrupoUsuario> getGrupoUsuarios() {
		return this.grupoUsuarios;
	}

	public void setGrupoUsuarios(List<GrupoUsuario> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

}