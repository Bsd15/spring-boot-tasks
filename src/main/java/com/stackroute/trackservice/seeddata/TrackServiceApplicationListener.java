package com.stackroute.trackservice.seeddata;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Class listens to Application Context events i.e. when application
 * starts or reloads and seeds predefined data into the database.
 */
@Component
public class TrackServiceApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
//   TrackService to perform database operations.
    private TrackService trackService;

    @Autowired
    public TrackServiceApplicationListener(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        Create seed data objects
        Track track1 = new Track(1, "Track 1", "Comment 1");
        Track track2 = new Track(2, "Track 2", "Comment 2");
        Track track3 = new Track(3, "Track 3", "Comment 3");
        try {
            trackService.saveTrack(track1);
            trackService.saveTrack(track2);
            trackService.saveTrack(track3);
        } catch (TrackAlreadyExistsException trackAlreadyExistsException) {
            trackAlreadyExistsException.printStackTrace();
        }
    }
}
