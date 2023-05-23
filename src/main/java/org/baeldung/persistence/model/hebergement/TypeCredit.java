package org.baeldung.persistence.model.hebergement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TypeCredit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String commentaire;
	private String dateCreation;
	private Long idUsercreePar;
	@NotNull
	private Long idBank;
	private Long idServiceBank;
	@NotNull
	private Double pFullCredit;
	@NotNull
	private Double pPartCredit;
	private int supprimer;
	public int getSupprimer() {
		return supprimer;
	}
	public void setSupprimer(int supprimer) {
		this.supprimer = supprimer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long idTypeCredit) {
		this.id = idTypeCredit;
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
	public Long getIdUsercreePar() {
		return idUsercreePar;
	}
	public void setIdUsercreePar(Long idUsercreePar) {
		this.idUsercreePar = idUsercreePar;
	}
	public Long getIdBank() {
		return idBank;
	}
	public void setIdBank(Long idBank) {
		this.idBank = idBank;
	}
	public Long getIdServiceBank() {
		return idServiceBank;
	}
	public void setIdServiceBank(Long idServiceBank) {
		this.idServiceBank = idServiceBank;
	}
	public Double getpFullCredit() {
		return pFullCredit;
	}
	public void setpFullCredit( Double pFullCredit) {
		this.pFullCredit = pFullCredit;
	}
	public  Double getpPartCredit() {
		return pPartCredit;
	}
	public void setpPartCredit(Double pPartCredit) {
		this.pPartCredit = pPartCredit;
	}
	@Override
	public String toString() {
		return "TypeCredit [idTypeCredit=" + id + ", commentaire=" + commentaire + ", dateCreation="
				+ dateCreation + ", idUsercreePar=" + idUsercreePar + ", idBank=" + idBank + ", idServiceBank="
				+ idServiceBank + ", pFullCredit=" + pFullCredit + ", pPartCredit=" + pPartCredit + "]";
	}
	
	
}
