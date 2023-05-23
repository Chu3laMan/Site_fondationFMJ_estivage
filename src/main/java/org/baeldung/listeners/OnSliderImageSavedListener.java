package org.baeldung.listeners;

import org.baeldung.events.OnSliderImageSavedEvent;
import org.baeldung.listeners.helper.TimersOfEvents;
import org.baeldung.listeners.helper.scheduleSliderImageTask;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Halim Zaaim
 *
 */
@Component
public class OnSliderImageSavedListener implements
      ApplicationListener<OnSliderImageSavedEvent> {

	@Override
	public void onApplicationEvent(OnSliderImageSavedEvent event) {
		 System.out.println("event handleded ....");
		scheduleSliderImageTask task = new scheduleSliderImageTask(event.getPeriod(),
				event.getImageName());
		 System.out.println("event added to the list of TilmersTasks ....");
		TimersOfEvents.addTaskTotimerEvent(task);
     
	}

}
