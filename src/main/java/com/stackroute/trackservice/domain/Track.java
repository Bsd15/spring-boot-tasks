package com.stackroute.trackservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Track entity to store tracks details
 * like trackId, trackName, comments.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Track {
    @Id
    private int trackId;
    private String trackName;
    private String comments;
}
