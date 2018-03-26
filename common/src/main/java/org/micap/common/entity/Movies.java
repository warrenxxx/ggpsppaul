package org.micap.common.entity;

import lombok.*;
import org.micap.common.enums.CategoryMovie;
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

public class Movies {
    private String _id;
    private String titulo;
    private String location;

    private CategoryMovie categoryMovies[];

    private Long duration;
    private String descriptcion;

    /**
     * Sets the _id.
     *
     * @param _id the _id to set
     * @return Movies
     */
    public Movies set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the titulo.
     *
     * @param titulo the titulo to set
     * @return Movies
     */
    public Movies setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    /**
     * Sets the location.
     *
     * @param location the location to set
     * @return Movies
     */
    public Movies setLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Sets the categoryMovies.
     *
     * @param categoryMovies the categoryMovies to set
     * @return Movies
     */
    public Movies setCategoryMovies(CategoryMovie[] categoryMovies) {
        this.categoryMovies = categoryMovies;
        return this;
    }

    /**
     * Sets the duration.
     *
     * @param duration the duration to set
     * @return Movies
     */
    public Movies setDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Sets the descriptcion.
     *
     * @param descriptcion the descriptcion to set
     * @return Movies
     */
    public Movies setDescriptcion(String descriptcion) {
        this.descriptcion = descriptcion;
        return this;
    }
}
