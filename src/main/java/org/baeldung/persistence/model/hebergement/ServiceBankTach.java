package org.baeldung.persistence.model.hebergement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ServiceBankTach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	private String commentaire;
	@NotNull
	private String dateCreation;
	private Long idUsercreePar;
	private Long idBank;
	private Long idServiceBank;
	private String hamichRib7;
	private String moda;
	private int supprimer;
	public Long getId() {
		return id;
	}
	public void setId(Long idTabServiceBankTach) {
		this.id = idTabServiceBankTach;
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
	public String getHamichRib7() {
		return hamichRib7;
	}
	public void setHamichRib7(String hamichRib7) {
		this.hamichRib7 = hamichRib7;
	}
	public String getModa() {
		return moda;
	}
	public void setModa(String moda) {
		this.moda = moda;
	}
	public int getSupprimer() {
		return supprimer;
	}
	public void setSupprimer(int supprimer) {
		this.supprimer = supprimer;
	}
	@Override
	public String toString() {
		return "TabServiceBankTach [idTabServiceBankTach=" + id + ", commentaire=" + commentaire
				+ ", dateCreation=" + dateCreation + ", idUsercreePar=" + idUsercreePar + ", idBank=" + idBank
				+ ", idServiceBank=" + idServiceBank + ", hamichRib7=" + hamichRib7 + ", moda=" + moda + ", supprimer="
				+ supprimer + "]";
	}
	
	
	

}
