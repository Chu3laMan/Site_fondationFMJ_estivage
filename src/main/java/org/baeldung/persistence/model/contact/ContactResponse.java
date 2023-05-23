package org.baeldung.persistence.model.contact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ContactResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "id_contact")
	private Long idContact;
	@NotNull
	@Column(name = "reponse", columnDefinition="LONGTEXT")
	private String reponse;
	@Column(name="admin_id")
	private Long idAdmin;
	@Column(name="reponse_date")
	private String reponseDate;
	@Column(name="reponse_type")
	private String type;
	private String distinataire;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdContact() {
		return idContact;
	}
	public void setIdContact(Long idContact) {
		this.idContact = idContact;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public Long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getReponseDate() {
		return reponseDate;
	}
	public void setReponseDate(String reponseDate) {
		this.reponseDate = reponseDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDistinataire() {
		return distinataire;
	}
	public void setDistinataire(String distinataire) {
		this.distinataire = distinataire;
	}
	@Override
	public String toString() {
		return "ContactResponse [id=" + id + ", idContact=" + idContact + ", reponse=" + reponse + ", idAdmin="
				+ idAdmin + ", reponseDate=" + reponseDate + ", type=" + type + "]";
	}
	
	
}
