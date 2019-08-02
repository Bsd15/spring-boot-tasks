package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implements TrackService to provide basic insert, delete, get operations on Tracks
 */
@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    /**
     * Insert track into the database.
     * @param track Track to be inserted in the database
     * @return Track created after inserting into the database.
     */
    @Override
    public Track saveTrack(Track track) {
        if (track != null) {
            return trackRepository.save(track);
        }
        return track;
    }

    /**
     * Finds the track in the database using the trackId.
     * @param id ID of the track to get from database
     * @return Track object
     */
    @Override
    public Track getTrack(int id) {
        return trackRepository.findById(id).get();
    }

    /**
     * Returns all the tracks in the database.
     * @return List of Tracks as List<Track>
     */
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    /**
     * Search tracks by Name
     * @param trackName Name of the track to be searched
     * @return List of tracks found with the given name
     */
    @Override
    public List<Track> searchTrackByName(String trackName) {
        List<Track> foundTracksList = trackRepository.searchTrackByName(trackName);
        return foundTracksList;
    }

    /**
     * First checks the track is present in the database and stores in a Optional.
     * If the track is present then deletes the track in the database and return the track
     * else return null.
     * @param id Id of the track to be deleted.
     * @return Track if deleted or null if the track is not found in the database.
     */
    @Override
    public Track deleteTrackById(int id) {
        Optional<Track> trackToBeDeleted = trackRepository.findById(id);
        if (trackToBeDeleted.isPresent()) {
            trackRepository.deleteById(id);
            return trackToBeDeleted.get();
        }
//        If the track to be deleted is not present in the database.
        return null;
    }

    /**
     * Deletes all the tracks in the database.
     */
    @Override
    public void deleteAllTracks() {
        trackRepository.deleteAll();
    }


    /**
     * Finds the Track by Id as a reference and updated it's fields and save's it.
     * @param trackId Id of the track to be updated
     * @param updatedTrack Track object containing the updated details
     * @return Updated track.
     */
    @Override
    public Track updateTrackById(int trackId, Track updatedTrack) {
//        Gets the reference to the Track object (lazy)
        Track trackToUpdate = trackRepository.getOne(trackId);
        trackToUpdate.setTrackName(updatedTrack.getTrackName());
        trackToUpdate.setComments(updatedTrack.getComments());
        return trackRepository.save(trackToUpdate);
    }

}
