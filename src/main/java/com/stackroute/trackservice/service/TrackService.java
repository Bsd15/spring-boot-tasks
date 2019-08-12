package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * TrackService provides method declarations for all the operations supported
 * in the application.
 */
public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException, Exception;

    public Track getTrack(int id) throws TrackNotFoundException, Exception;

    public List<Track> getAllTracks() throws Exception;

    public List<Track> searchTrackByName(String trackName) throws TrackNotFoundException, Exception;

    public Track deleteTrackById(int id) throws TrackNotFoundException, Exception;

    public boolean deleteAllTracks() throws Exception;

    public Track updateTrackById(int trackId, Track updatedTrack) throws TrackNotFoundException, Exception;
}
