package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TrackController {
    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    /**
     * Insert track into the database
     * @param track Track to be inserted
     * @return Newly created track
     */
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        Track newTrack = trackService.saveTrack(track);
        return new ResponseEntity<>(newTrack, HttpStatus.CREATED);
    }

    /**
     * Search Track
     * @param id Id of the track
     * @return Track
     */
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrack(@PathVariable int id) {
        Track retrievedTrack = trackService.getTrack(id);
        return new ResponseEntity<>(retrievedTrack,HttpStatus.FOUND);
    }

    /**
     * Get all tracks
     * @return All tracks in the database
     */
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        List<Track> trackList = trackService.getAllTracks();
        return new ResponseEntity<>(trackList, HttpStatus.FOUND);
    }

    /**
     * Search Track By name.
     * @param trackName Name of the track to search.
     * @return List of tracks
     */
    @GetMapping("tracks/name/{trackName}")
    public ResponseEntity<?> searchTrackByName(@PathVariable String trackName) {
        List<Track> foundTracksList = trackService.searchTrackByName(trackName);
        return new ResponseEntity<>(foundTracksList, HttpStatus.FOUND);
    }

    /**
     * Delete track by ID
     * @param id Track Id to be deleted
     * @return Deleted Track
     */
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
        Track deletedTrack = trackService.deleteTrackById(id);
        return new ResponseEntity<>(deletedTrack, HttpStatus.OK);
    }

    /**
     * Delete all tracks in the database.
     * @return Success Message when all tracks are deleted.
     */
    @DeleteMapping("track")
    public ResponseEntity<?> deleteAllTracks() {
        trackService.deleteAllTracks();
        return new ResponseEntity<>("Deleted ", HttpStatus.OK);
    }

    /**
     * Update Track by Id.
     * @param id Id of the track to be updated.
     * @param track Track object containing updated track details.
     * @return Updated track
     */
    @PutMapping("track/{id}")
    public ResponseEntity<?> updateTrackById(@PathVariable("id") int id ,@RequestBody Track track) {
        Track updatedTrack = trackService.updateTrackById(id,track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }
}
