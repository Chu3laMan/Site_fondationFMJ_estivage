package org.baeldung.persistence.model.transport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "Transport_Tab")
public class Transport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(max = 60)
	private String type;
	@NotNull
	private String libelle;
	@Column(name = "commentaire", columnDefinition = "LONGTEXT")
	private String commentaire;
	@Lob
	@Column(name = "image" , columnDefinition = "MEDIUMBLOB")
	private String image;
	@Nullable
	@Column(name = "T_condition", columnDefinition = "MEDIUMTEXT")
	private String condition;
	@Nullable
	private String attachmentURL;
	private int status;
	@Size(max = 20)
	private String date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getAttachmentURL() {
		return attachmentURL;
	}
	public void setAttachmentURL(String attachmentURL) {
		this.attachmentURL = attachmentURL;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
