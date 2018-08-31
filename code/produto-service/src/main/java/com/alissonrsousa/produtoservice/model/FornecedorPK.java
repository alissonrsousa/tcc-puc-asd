package com.alissonrsousa.produtoservice.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the fornecedor database table.
 * 
 */
@Embeddable
public class FornecedorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="endereco_id")
	private int enderecoId;

	@Column(name="usuario_id")
	private int usuarioId;

	public FornecedorPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnderecoId() {
		return this.enderecoId;
	}
	public void setEnderecoId(int enderecoId) {
		this.enderecoId = enderecoId;
	}
	public int getUsuarioId() {
		return this.usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FornecedorPK)) {
			return false;
		}
		FornecedorPK castOther = (FornecedorPK)other;
		return 
			(this.id == castOther.id)
			&& (this.enderecoId == castOther.enderecoId)
			&& (this.usuarioId == castOther.usuarioId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.enderecoId;
		hash = hash * prime + this.usuarioId;
		
		return hash;
	}
}