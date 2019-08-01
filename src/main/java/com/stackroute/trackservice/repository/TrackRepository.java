package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface to perform database operations
 */
@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
}
