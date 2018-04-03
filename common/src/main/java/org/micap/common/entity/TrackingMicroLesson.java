package org.micap.common.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode

public class TrackingMicroLesson {
    private String _id;
    private String user;
    private MicroLessonDetail microLessonDetails[];

    public TrackingMicroLesson set_id(String _id) {
        this._id = _id;
        return this;
    }

    public TrackingMicroLesson setUser(String user) {
        this.user = user;
        return this;
    }

    public TrackingMicroLesson setMicroLessonDetails(MicroLessonDetail[] microLessonDetails) {
        this.microLessonDetails = microLessonDetails;
        return this;
    }
}
