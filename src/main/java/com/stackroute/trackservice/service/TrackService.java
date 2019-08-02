package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;

import java.util.List;
import java.util.Optional;

/**
 * TrackService provides method declarations for all the operations supported
 * in the application.
 */
public interface TrackService {

    public Track saveTrack(Track track);

    public Track getTrack(int id);

    public List<Track> getAllTracks();

    public List<Track> searchTrackByName(String trackName);

    public Track deleteTrackById(int id);

    public void deleteAllTracks();

    public Track updateTrackById(int trackId, Track updatedTrack);
}
