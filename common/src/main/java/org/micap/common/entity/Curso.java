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
public class Curso {
    private String masterId;//userId
    private String _id;
    private String name;
    public String MicroLessonId[];

    public Curso setMasterId(String masterId) {
        this.masterId = masterId;
        return this;
    }

    public Curso set_id(String _id) {
        this._id = _id;
        return this;
    }

    public Curso setName(String name) {
        this.name = name;
        return this;
    }

    public Curso setMicroLessonId(String[] microLessonId) {
        MicroLessonId = microLessonId;
        return this;
    }
}

