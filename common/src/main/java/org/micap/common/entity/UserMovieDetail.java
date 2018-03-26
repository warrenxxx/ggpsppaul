package org.micap.common.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The UserMovieDetail class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :26/03/2018
 */
@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode

public class UserMovieDetail {
    public String _id;
    public Long timeResume;
    public Boolean isComplete;

    /**
     * Sets the _id.
     *
     * @param _id the _id to set
     * @return UserMovieDetail
     */
    public UserMovieDetail set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the timeResume.
     *
     * @param timeResume the timeResume to set
     * @return UserMovieDetail
     */
    public UserMovieDetail setTimeResume(Long timeResume) {
        this.timeResume = timeResume;
        return this;
    }

    /**
     * Sets the complete.
     *
     * @param complete the complete to set
     * @return UserMovieDetail
     */
    public UserMovieDetail setComplete(Boolean complete) {
        isComplete = complete;
        return this;
    }
}
