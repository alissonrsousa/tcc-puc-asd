package com.alissonrsousa.produtoservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the propaganda database table.
 * 
 */
@Entity
@Table(name="propaganda")
@NamedQuery(name="Propaganda.findAll", query="SELECT p FROM Propaganda p")
public class Propaganda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String imagem;

	private String nome;

	//bi-directional many-to-one association to PropagandaMailList
	@OneToMany(mappedBy="propaganda")
	private List<PropagandaMailList> propagandaMailLists;

	public Propaganda() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagem() {
		return this.imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PropagandaMailList> getPropagandaMailLists() {
		return this.propagandaMailLists;
	}

	public void setPropagandaMailLists(List<PropagandaMailList> propagandaMailLists) {
		this.propagandaMailLists = propagandaMailLists;
	}

	public PropagandaMailList addPropagandaMailList(PropagandaMailList propagandaMailList) {
		getPropagandaMailLists().add(propagandaMailList);
		propagandaMailList.setPropaganda(this);

		return propagandaMailList;
	}

	public PropagandaMailList removePropagandaMailList(PropagandaMailList propagandaMailList) {
		getPropagandaMailLists().remove(propagandaMailList);
		propagandaMailList.setPropaganda(null);

		return propagandaMailList;
	}

}