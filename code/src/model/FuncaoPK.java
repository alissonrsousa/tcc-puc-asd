package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the funcao database table.
 * 
 */
@Embeddable
public class FuncaoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="modulo_id", insertable=false, updatable=false)
	private int moduloId;

	public FuncaoPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getModuloId() {
		return this.moduloId;
	}
	public void setModuloId(int moduloId) {
		this.moduloId = moduloId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FuncaoPK)) {
			return false;
		}
		FuncaoPK castOther = (FuncaoPK)other;
		return 
			(this.id == castOther.id)
			&& (this.moduloId == castOther.moduloId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.moduloId;
		
		return hash;
	}
}