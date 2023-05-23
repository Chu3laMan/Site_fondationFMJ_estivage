package org.baeldung.persistence.model.home;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	@Lob
    @Column(name = "description", columnDefinition="LONGTEXT")
	private String description;
	@NonNull
	private int status;
	@Nullable
	private String attachmentURL;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getAttachmentURL() {
		return attachmentURL;
	}
	public void setAttachmentURL(String attachmentURL) {
		this.attachmentURL = attachmentURL;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", description=" + description + ", status=" + status + "]";
	}
	
}
