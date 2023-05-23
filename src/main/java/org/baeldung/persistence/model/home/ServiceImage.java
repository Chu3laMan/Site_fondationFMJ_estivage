package org.baeldung.persistence.model.home;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;



@Entity
public class ServiceImage {

	@Id
	@Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String imageName;
	@Lob
	@Column(name = "service_image", columnDefinition="MEDIUMBLOB")
	private String service_image;
	private String ServiceName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	public String getService_image() {
		return service_image;
	}
	public void setService_image(String service_image) {
		this.service_image = service_image;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Override
	public String toString() {
		return "ServiceImage [id=" + id + ", imageName=" + imageName + ","
				+ " service_image=" + service_image
				+ ", ServiceName=" + ServiceName + "]";
	}
	
}
