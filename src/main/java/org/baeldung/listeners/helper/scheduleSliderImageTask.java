package org.baeldung.listeners.helper;

import java.util.TimerTask;

import org.baeldung.persistence.model.home.SliderImage;
import org.hibernate.Session;

/**
 * @author Halim Zaaim
 *
 */

public class scheduleSliderImageTask extends TimerTask {
	private Long taskPeriod;
	private String imgName;
	
	public scheduleSliderImageTask(Long taskPeriod, String imgName) {
		super();
	    this.taskPeriod = taskPeriod;
		this.imgName = imgName;
	
	}

	public Long getTaskPeriod() {
		return taskPeriod;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public void setTaskPeriod(Long taskPeriod) {
		this.taskPeriod = taskPeriod;
	}

	@Override
	public void run() {
	
    	System.out.println("starting the task ....");
    
		System.out.println("task fineshed ....");
	}

	public String getImgName() {
		return imgName;
	}

	@Override
	public String toString() {
		return "scheduleSliderImageTask [taskPeriod=" + taskPeriod + ", imgName=" + imgName + "]";
	}
	

}
