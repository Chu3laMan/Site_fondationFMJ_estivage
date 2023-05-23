package org.baeldung.persistence.model.hebergement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ServiceImmob {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String commentaire;
	@NotNull
	private String dateCreation;
	private Long idUsercreePar;
	@NotNull
	private Long idSocietImob;
	private Long idProdImob;
	private String promotion;
	private String localisation;
	private int supprimer;

	public Long getId() {
		return id;
	}

	public void setId(Long idTabServicImob) {
		this.id = idTabServicImob;
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

	public Long getIdSocietImob() {
		return idSocietImob;
	}

	public void setIdSocietImob(Long idSocietImob) {
		this.idSocietImob = idSocietImob;
	}

	public Long getIdProdImob() {
		return idProdImob;
	}

	public void setIdProdImob(Long idProdImob) {
		this.idProdImob = idProdImob;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public int getSupprimer() {
		return supprimer;
	}

	public void setSupprimer(int supprimer) {
		this.supprimer = supprimer;
	}

	@Override
	public String toString() {
		return "TabServiceImmob [idTabServicImob=" + id + ", commentaire=" + commentaire
				+ ", dateCreation=" + dateCreation + ", idUsercreePar=" + idUsercreePar + ", idSocietImob="
				+ idSocietImob + ", idProdImob=" + idProdImob + ", promotion=" + promotion + ", localisation="
				+ localisation + ", supprimer=" + supprimer + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceImmob other = (ServiceImmob) obj;
		if (commentaire == null) {
			if (other.commentaire != null)
				return false;
		} else if (!commentaire.equals(other.commentaire))
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idProdImob == null) {
			if (other.idProdImob != null)
				return false;
		} else if (!idProdImob.equals(other.idProdImob))
			return false;
		if (idSocietImob == null) {
			if (other.idSocietImob != null)
				return false;
		} else if (!idSocietImob.equals(other.idSocietImob))
			return false;
		if (idUsercreePar == null) {
			if (other.idUsercreePar != null)
				return false;
		} else if (!idUsercreePar.equals(other.idUsercreePar))
			return false;
		if (localisation == null) {
			if (other.localisation != null)
				return false;
		} else if (!localisation.equals(other.localisation))
			return false;
		if (promotion == null) {
			if (other.promotion != null)
				return false;
		} else if (!promotion.equals(other.promotion))
			return false;
		if (supprimer != other.supprimer)
			return false;
		return true;
	}

}
