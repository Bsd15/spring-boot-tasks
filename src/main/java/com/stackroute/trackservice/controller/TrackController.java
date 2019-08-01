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

    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrack(@PathVariable int id) {
        Track retrievedTrack = trackService.getTrack(id);
        return new ResponseEntity<>(retrievedTrack,HttpStatus.FOUND);
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        List<Track> trackList = trackService.getAllTracks();
        return new ResponseEntity<>(trackList, HttpStatus.FOUND);
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
        Track deletedTrack = trackService.deleteTrackById(id);
        return new ResponseEntity<>(deletedTrack, HttpStatus.OK);
    }

    @DeleteMapping("track")
    public ResponseEntity<?> deleteAllTracks() {
        trackService.deleteAllTracks();
        return new ResponseEntity<>("Deleted ", HttpStatus.OK);
    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> updateTrackById(@PathVariable("id") int id ,@RequestBody Track track) {
        Track updatedTrack = trackService.updateTrackById(id,track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }
}
