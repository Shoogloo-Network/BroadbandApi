package com.bb.primary.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the m_language database table.
 * 
 */
@Entity
@Table(name="m_language")
@NamedQuery(name="MLanguage.findAll", query="SELECT m FROM MLanguage m")
public class MLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String language;

	//bi-directional many-to-one association to MTranslate
	@OneToMany(mappedBy="MLanguage")
	private List<MTranslate> MTranslates;

	public MLanguage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<MTranslate> getMTranslates() {
		return this.MTranslates;
	}

	public void setMTranslates(List<MTranslate> MTranslates) {
		this.MTranslates = MTranslates;
	}

	public MTranslate addMTranslate(MTranslate MTranslate) {
		getMTranslates().add(MTranslate);
		MTranslate.setMLanguage(this);

		return MTranslate;
	}

	public MTranslate removeMTranslate(MTranslate MTranslate) {
		getMTranslates().remove(MTranslate);
		MTranslate.setMLanguage(null);

		return MTranslate;
	}

}