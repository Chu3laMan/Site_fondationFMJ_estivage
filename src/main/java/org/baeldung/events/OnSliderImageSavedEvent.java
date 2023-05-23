
package org.baeldung.events;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.springframework.context.ApplicationEvent;

/**
 * @author Halim Zaaim
 *
 */
public class OnSliderImageSavedEvent extends ApplicationEvent {

	private static final long serialVersionUID = 6692178681908321579L;
	private LocalDate insertionDate;
	private LocalDate expireDate;
	private Long period;
	private String imageName;

	public OnSliderImageSavedEvent(Object source, LocalDate insertionDate, LocalDate expireDate, String imageName) {
		super(source);
		this.insertionDate = insertionDate;
		this.expireDate = expireDate;
		this.imageName = imageName;
		this.setPeriod();
	}

	public LocalDate getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(LocalDate insertionDate) {
		this.insertionDate = insertionDate;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getPeriod() {
		return period;
	}

	public void setPeriod() {
		this.period = calculatePeriod();
	}

	private Long calculatePeriod() {
		return ChronoUnit.DAYS.between(insertionDate,expireDate); 
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
 // for testing purpose 
	@Override
	public String toString() {
		return "OnSliderImageSavedEvent [insertionDate=" + insertionDate + ", expireDate=" + expireDate + ", period="
				+ period + ", imageName=" + imageName + "]";
	}

}
