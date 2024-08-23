package com.bb.primary.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the m_translate database table.
 * 
 */
@Entity
@Table(name="m_translate")
@NamedQuery(name="MTranslate.findAll", query="SELECT m FROM MTranslate m")
public class MTranslate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String englsih;

	private String translation;

	//bi-directional many-to-one association to MLanguage
	@ManyToOne
	@JoinColumn(name="languageId")
	private MLanguage MLanguage;

	public MTranslate() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnglsih() {
		return this.englsih;
	}

	public void setEnglsih(String englsih) {
		this.englsih = englsih;
	}

	public String getTranslation() {
		return this.translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public MLanguage getMLanguage() {
		return this.MLanguage;
	}

	public void setMLanguage(MLanguage MLanguage) {
		this.MLanguage = MLanguage;
	}

}