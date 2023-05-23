package org.baeldung.persistence.model.publication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Column(columnDefinition = "LONGTEXT")
	private String publication;
	@NotNull
	private String atachmentURL;
	private int status;
	private String date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getAtachmentURL() {
		return atachmentURL;
	}
	public void setAtachmentURL(String atachmentURL) {
		this.atachmentURL = atachmentURL;
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
	@Override
	public String toString() {
		return "Publication [id=" + id + ", publication=" + publication + ","
				+ " atachmentURL=" + atachmentURL + ", status="
				+ status + "]";
	}
	

}
