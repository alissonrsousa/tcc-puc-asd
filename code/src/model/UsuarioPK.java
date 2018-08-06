package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuario database table.
 * 
 */
@Embeddable
public class UsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="status_usuario_id", insertable=false, updatable=false)
	private int statusUsuarioId;

	public UsuarioPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatusUsuarioId() {
		return this.statusUsuarioId;
	}
	public void setStatusUsuarioId(int statusUsuarioId) {
		this.statusUsuarioId = statusUsuarioId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioPK)) {
			return false;
		}
		UsuarioPK castOther = (UsuarioPK)other;
		return 
			(this.id == castOther.id)
			&& (this.statusUsuarioId == castOther.statusUsuarioId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.statusUsuarioId;
		
		return hash;
	}
}