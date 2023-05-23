package org.baeldung.persistence.model.hebergement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity
public class Codification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
    @Lob
    @Column(columnDefinition="MEDIUMBLOB")
	private String image;
	private String commentaire;
	private String dateCreation;
	private Long  idUserCreePar;
	@NotNull
	private String libelle;
	@NotNull
	private String nomTable;
	private int supprimer;
	public Long getId() {
		return id;
	}
	public void setId(Long iDCodification) {
		id = iDCodification;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String codeImage) {
		this.image = codeImage;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Long getIdUserCreePar() {
		return idUserCreePar;
	}
	public void setIdUserCreePar(Long idUserCreePar) {
		this.idUserCreePar = idUserCreePar;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getNomTable() {
		return nomTable;
	}
	public void setNomTable(String nomeTable) {
		this.nomTable = nomeTable;
	}
	public int getSupprimer() {
		return supprimer;
	}
	public void setSupprimer(int supprimer) {
		this.supprimer = supprimer;
	}
	@Override
	public String toString() {
		return "Codification [id=" + id + ", image=" + image + ", commentaire=" + commentaire + ", dateCreation="
				+ dateCreation + ", idUserCreePar=" + idUserCreePar + ", libelle=" + libelle + ", nomTable=" + nomTable
				+ ", supprimer=" + supprimer + "]";
	}
		

}
