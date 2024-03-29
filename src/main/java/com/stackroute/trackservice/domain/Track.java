package com.stackroute.trackservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Track entity to store tracks details
 * like trackId, trackName, comments.
 */
@Entity
public class Track {
    @Id
    private int trackId;
    private String trackName;
    private String comments;

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
