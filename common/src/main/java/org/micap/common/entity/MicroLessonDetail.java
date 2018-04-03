package org.micap.common.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
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

public class MicroLessonDetail {
    public String _idMicroLesson;
    public Long viewDate;
    public Boolean isComplete;
    public Long resume;
    public Long rank;

    public MicroLessonDetail set_idMicroLesson(String _idMicroLesson) {
        this._idMicroLesson = _idMicroLesson;
        return this;
    }

    public MicroLessonDetail setViewDate(Long viewDate) {
        this.viewDate = viewDate;
        return this;
    }

    public MicroLessonDetail setComplete(Boolean complete) {
        isComplete = complete;
        return this;
    }

    public MicroLessonDetail setResume(Long resume) {
        this.resume = resume;
        return this;
    }

    public MicroLessonDetail setRank(Long rank) {
        this.rank = rank;
        return this;
    }
}
