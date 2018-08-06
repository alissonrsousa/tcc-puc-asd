package com.alissonrsousa.segurancaservice.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the grupo_usuario_funcao database table.
 * 
 */
@Embeddable
public class GrupoUsuarioFuncaoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="grupo_usuario_id", insertable=false, updatable=false)
	private int grupoUsuarioId;
	
	@Column(name="funcao_id", insertable=false, updatable=false)
	private int funcaoId;

	public GrupoUsuarioFuncaoPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrupoUsuarioId() {
		return grupoUsuarioId;
	}
	public void setGrupoUsuarioId(int grupoUsuarioId) {
		this.grupoUsuarioId = grupoUsuarioId;
	}
	public int getFuncaoId() {
		return funcaoId;
	}
	public void setFuncaoId(int funcaoId) {
		this.funcaoId = funcaoId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + funcaoId;
		result = prime * result + grupoUsuarioId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoUsuarioFuncaoPK other = (GrupoUsuarioFuncaoPK) obj;
		if (funcaoId != other.funcaoId)
			return false;
		if (grupoUsuarioId != other.grupoUsuarioId)
			return false;
		return true;
	}

}