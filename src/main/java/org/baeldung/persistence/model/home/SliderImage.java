package org.baeldung.persistence.model.home;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity
public class SliderImage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
    private String imageName;
    private String description;
    @NotNull
    @Lob
    @Column(name = "image", columnDefinition="MEDIUMBLOB")
    private String image;
    @NotNull
    private int status;
    
    @NotNull
    private String dateOfInsertion;
   
    @NotNull
    private String dateOfExperation;
    
	public String getDateOfInsertion() {
		return dateOfInsertion;
	}
	public void setDateOfInsertion(String dateOfInsertion) {
		this.dateOfInsertion = dateOfInsertion;
	}
	public String getDateOfExperation() {
		return dateOfExperation;
	}
	public void setDateOfExperation(String dateOfExperation) {
		this.dateOfExperation = dateOfExperation;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "SliderImage [id=" + id + ", imageName=" + imageName + ", description=" + description + ", image="
				+ image + ", status=" + status + ", dateOfInsertion=" + dateOfInsertion + ", dateOfExperation="
				+ dateOfExperation + "]";
	}
	   
}
