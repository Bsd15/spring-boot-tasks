package com.stackroute.trackservice.exceptions;

/**
 * This is exception is thrown while trying to create a new Track.
 * If a track with the trackId is already present in the database this exception is
 * raised.
 */
public class TrackAlreadyExistsException extends Exception {
    public TrackAlreadyExistsException(String message) {
        super(message);
    }
}
