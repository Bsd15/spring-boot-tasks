package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("dummy")
public class TrackDummyServiceImpl implements TrackService {
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        return null;
    }

    @Override
    public Track getTrack(int id) throws TrackNotFoundException {
        return null;
    }

    @Override
    public List<Track> getAllTracks() throws Exception {
        return null;
    }

    @Override
    public List<Track> searchTrackByName(String trackName) throws TrackNotFoundException {
        return null;
    }

    @Override
    public Track deleteTrackById(int id) throws TrackNotFoundException {
        return null;
    }

    @Override
    public boolean deleteAllTracks() {
        return true;
    }

    @Override
    public Track updateTrackById(int trackId, Track updatedTrack) throws TrackNotFoundException {
        return null;
    }
}
