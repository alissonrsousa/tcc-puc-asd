package com.alissonrsousa.produtoservice.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="propaganda_mail_list")
@NamedQuery(name="PropagandaMailList.findAll", query="SELECT p FROM PropagandaMailList p")
public class PropagandaMailList implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PropagandaMailListPK id;

	//bi-directional many-to-one association to Propaganda
	@ManyToOne
	private Propaganda propaganda;

	public PropagandaMailList() {
	}

	public PropagandaMailListPK getId() {
		return this.id;
	}

	public void setId(PropagandaMailListPK id) {
		this.id = id;
	}

	public Propaganda getPropaganda() {
		return this.propaganda;
	}

	public void setPropaganda(Propaganda propaganda) {
		this.propaganda = propaganda;
	}

}