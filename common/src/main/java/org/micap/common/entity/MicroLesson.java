package org.micap.common.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Movies class is implemment to
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

public class MicroLesson{
    private String _id;
    private String titulo;

    private String location;

    private String categoryMovies[];

    private Long duration;
    private String descriptcion;
    private String userId;


    private String script;
    private Audit audit;

    private String  idCursos[];
}
