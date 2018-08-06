package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grupo_usuario_funcao database table.
 * 
 */
@Entity
@Table(name="grupo_usuario_funcao")
@NamedQuery(name="GrupoUsuarioFuncao.findAll", query="SELECT g FROM GrupoUsuarioFuncao g")
public class GrupoUsuarioFuncao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GrupoUsuarioFuncaoPK id;

	public GrupoUsuarioFuncao() {
	}

	public GrupoUsuarioFuncaoPK getId() {
		return this.id;
	}

	public void setId(GrupoUsuarioFuncaoPK id) {
		this.id = id;
	}

}