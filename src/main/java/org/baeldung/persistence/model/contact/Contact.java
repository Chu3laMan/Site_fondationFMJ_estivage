package org.baeldung.persistence.model.contact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String nom;
	@NotNull
	private String email;
	private String sujet;
	@NotNull
	@Column(name = "contenu", columnDefinition="LONGTEXT")
	private String contenu;
	@Column(name = "contact_date")
	private String  date;
	@Column(name="contact_type")
	private String type;
	private int lire;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getLire() {
		return lire;
	}
	public void setLire(int lire) {
		this.lire = lire;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", nom=" + nom + ", email=" + email + ", sujet=" + sujet + ", contenu=" + contenu
				+ ", date=" + date + ", type=" + type + "]";
	}
	

}
