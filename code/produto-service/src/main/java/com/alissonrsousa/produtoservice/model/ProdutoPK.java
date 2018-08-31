package com.alissonrsousa.produtoservice.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the produto database table.
 * 
 */
@Embeddable
public class ProdutoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="categoria_id", insertable=false, updatable=false)
	private int categoriaId;

	public ProdutoPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoriaId() {
		return this.categoriaId;
	}
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProdutoPK)) {
			return false;
		}
		ProdutoPK castOther = (ProdutoPK)other;
		return 
			(this.id == castOther.id)
			&& (this.categoriaId == castOther.categoriaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.categoriaId;
		
		return hash;
	}
}