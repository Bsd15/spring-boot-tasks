package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class TrackServiceTest {
    @Mock
    private TrackRepository trackRepository;
    @InjectMocks
    private TrackServiceImpl trackService;

    private Track track;
    private List<Track> trackList; /*To store multiple tracks and used as expected */


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        track = new Track(1, "Track 1", "Comment");
        trackList = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {
//        trackService.deleteAllTracks();
    }

    /**
     * Test - TrackServiceImpl.saveTrack()
     * @throws TrackAlreadyExistsException
     */
    @Test
    public void givenTrackToSaveShouldReturnTrack() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track) any())).thenReturn(track);
        Track resultTrack = trackService.saveTrack(track);
        assertEquals("givenTrackToSaveShouldReturnTrack(): save() did not return Track object.",
                track, resultTrack);
        verify(trackRepository, times(1)).save(track);
    }

    /**
     * Test - saveTrack()
     * Should throw TrackAlreadyExistsException
     * FIXME Test fails
     * @throws TrackAlreadyExistsException
     */

    @Test(expected = TrackAlreadyExistsException.class)
    public void givenTrackToSaveAgainShouldThrowTrackAlreadyExistsException() throws TrackAlreadyExistsException {
        when(trackRepository.existsById(track.getTrackId())).thenReturn(true);
        Track resultTrack = trackService.saveTrack(track);
//        Track resultTrack2=trackService.saveTrack(track);
    }

//    @Test
//    public void givenTrackIdShouldReturnTrack() {
//        when(trackRepository.findById((int) any())).thenReturn(new Optional<>());
//    }

}