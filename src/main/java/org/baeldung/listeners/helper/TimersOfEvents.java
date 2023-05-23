package org.baeldung.listeners.helper;

import java.util.HashMap;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
/**
 * @author Halim Zaaim
 *
 */
public class TimersOfEvents {
	public static HashMap<String, Timer> listOfTimers =   new HashMap<String, Timer>();

	public TimersOfEvents() {
		super();

	}

	public static void addTaskTotimerEvent(scheduleSliderImageTask task) {
		// register a timer under the name of the image
		Timer t = new Timer();
		///Long delay = TimeUnit.DAYS.toMillis(task.getTaskPeriod());
		//Long delay = (long) 60000;
		t.schedule(task, (long) 60000);
		listOfTimers.put(task.getImgName(),t);
	}
    /**
     * 
     * @param imageName
     * @return Timer
     * return a timer associated with a task for further processing 
     */
	public static Timer getTimerFromListOfTimers(String imageName)
	{		
		return listOfTimers.get(imageName);
	}
    
	/**
	 * 
	 * @param imageName
	 * @param newdelay
	 * we actually terminate the old timer 
	 * & then construct a new task !
	 * & associate the task with another timer 
	 * & we add the timer to the hashMap of existing Timers 
	 * 
	 */
	public static void updateTheTimer(String imageName,Long newdelay)
	{
		Long delay = TimeUnit.DAYS.toMillis(newdelay);
		Timer newTimer = new Timer();
		//cancel the expired timer
		listOfTimers.get(imageName).cancel();
		//remove the expired timer
		listOfTimers.remove(imageName);
		scheduleSliderImageTask newTask = new scheduleSliderImageTask(newdelay, imageName);
		newTimer.schedule(newTask, delay);
		listOfTimers.put(imageName,newTimer);
	}
}
