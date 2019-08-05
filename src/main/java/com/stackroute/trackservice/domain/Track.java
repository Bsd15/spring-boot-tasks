package com.stackroute.trackservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Track entity to store tracks details
 * like trackId, trackName, comments.
 */
@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Track {
    @Id
    private int trackId;
    private String trackName;
    private String comments;
}
