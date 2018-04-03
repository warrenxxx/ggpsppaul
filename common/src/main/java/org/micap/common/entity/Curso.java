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
}
