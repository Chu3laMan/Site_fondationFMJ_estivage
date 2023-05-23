package org.baeldung.persistence.model.publication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manachir {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String attachmentURL;
	@Column(columnDefinition="LONGTEXT")
	private String menchor;
	private String date;
	private int status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAttachmentURL() {
		return attachmentURL;
	}
	public void setAttachmentURL(String attachmentURL) {
		this.attachmentURL = attachmentURL;
	}
	public String getMenchor() {
		return menchor;
	}
	public void setMenchor(String menchor) {
		this.menchor = menchor;
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
		return "Manachir [id=" + id + ", attachmentURL=" + 
	            attachmentURL + ", menchor=" + menchor + ", date=" + date
				+ ", status=" + status + "]";
	}
	
}
