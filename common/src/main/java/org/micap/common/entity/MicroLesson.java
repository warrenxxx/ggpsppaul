package org.micap.common.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
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
    @Id
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

    /**
     * Sets the _id.
     *
     * @param _id the _id to set
     * @return MicroLesson
     */
    public MicroLesson set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the titulo.
     *
     * @param titulo the titulo to set
     * @return MicroLesson
     */
    public MicroLesson setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    /**
     * Sets the location.
     *
     * @param location the location to set
     * @return MicroLesson
     */
    public MicroLesson setLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Sets the categoryMovies.
     *
     * @param categoryMovies the categoryMovies to set
     * @return MicroLesson
     */
    public MicroLesson setCategoryMovies(String[] categoryMovies) {
        this.categoryMovies = categoryMovies;
        return this;
    }

    /**
     * Sets the duration.
     *
     * @param duration the duration to set
     * @return MicroLesson
     */
    public MicroLesson setDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Sets the descriptcion.
     *
     * @param descriptcion the descriptcion to set
     * @return MicroLesson
     */
    public MicroLesson setDescriptcion(String descriptcion) {
        this.descriptcion = descriptcion;
        return this;
    }

    /**
     * Sets the userId.
     *
     * @param userId the userId to set
     * @return MicroLesson
     */
    public MicroLesson setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Sets the script.
     *
     * @param script the script to set
     * @return MicroLesson
     */
    public MicroLesson setScript(String script) {
        this.script = script;
        return this;
    }

    /**
     * Sets the audit.
     *
     * @param audit the audit to set
     * @return MicroLesson
     */
    public MicroLesson setAudit(Audit audit) {
        this.audit = audit;
        return this;
    }

    /**
     * Sets the idCursos.
     *
     * @param idCursos the idCursos to set
     * @return MicroLesson
     */
    public MicroLesson setIdCursos(String[] idCursos) {
        this.idCursos = idCursos;
        return this;
    }
}
