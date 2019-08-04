package com.stackroute.trackservice.exceptions;

/**
 * Thrown when a track being searched is not found in the database.
 */
public class TrackNotFoundException extends Exception {
    public TrackNotFoundException(String message) {
        super(message);
    }

    public TrackNotFoundException() {

    }
}
