package com.alissonrsousa.produtoservice.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the propaganda_mail_list database table.
 * 
 */
@Embeddable
public class PropagandaMailListPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="propaganda_id", insertable=false, updatable=false)
	private int propagandaId;

	@Column(name="mail_list_id")
	private int mailListId;

	public PropagandaMailListPK() {
	}
	public int getPropagandaId() {
		return this.propagandaId;
	}
	public void setPropagandaId(int propagandaId) {
		this.propagandaId = propagandaId;
	}
	public int getMailListId() {
		return this.mailListId;
	}
	public void setMailListId(int mailListId) {
		this.mailListId = mailListId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PropagandaMailListPK)) {
			return false;
		}
		PropagandaMailListPK castOther = (PropagandaMailListPK)other;
		return 
			(this.propagandaId == castOther.propagandaId)
			&& (this.mailListId == castOther.mailListId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.propagandaId;
		hash = hash * prime + this.mailListId;
		
		return hash;
	}
}