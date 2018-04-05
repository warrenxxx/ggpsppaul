package org.micap.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Document
public class Course {
    private String masterId;//userId
    private String _id;
    private String name;
    public String MicroLessonId[];

    public Course setMasterId(String masterId) {
        this.masterId = masterId;
        return this;
    }

    public Course set_id(String _id) {
        this._id = _id;
        return this;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public Course setMicroLessonId(String[] microLessonId) {
        MicroLessonId = microLessonId;
        return this;
    }
}

