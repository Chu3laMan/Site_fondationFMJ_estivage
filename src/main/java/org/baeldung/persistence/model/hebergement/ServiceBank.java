package org.baeldung.persistence.model.hebergement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ServiceBank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String commentaire;
	private String dateCreation;
	private Long idUsercreePar;
	@NotNull
	private Long idBank;
	private Long idServiceBank;
	private String faida;
	private String moda;
	private String sakf;
	@NotNull
	private int supprimer;
	public Long getId() {
		return id;
	}
	public void setId(Long idTabServiceBank) {
		this.id = idTabServiceBank;
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
	public String getFaida() {
		return faida;
	}
	public void setFaida(String faida) {
		this.faida = faida;
	}
	public String getModa() {
		return moda;
	}
	public void setModa(String moda) {
		this.moda = moda;
	}
	public String getSakf() {
		return sakf;
	}
	public void setSakf(String sakf) {
		this.sakf = sakf;
	}
	public int getSupprimer() {
		return supprimer;
	}
	public void setSupprimer(int supprimer) {
		this.supprimer = supprimer;
	}
	@Override
	public String toString() {
		return "TabServiceBank [idTabServiceBank=" + id + ", commentaire=" + commentaire
				+ ", dateCreation=" + dateCreation + ", idUsercreePar=" + idUsercreePar + ", idBank=" + idBank
				+ ", idServiceBank=" + idServiceBank + ", faida=" + faida + ", moda=" + moda + ", sakf=" + sakf
				+ ", supprimer=" + supprimer + "]";
	}
	

}
