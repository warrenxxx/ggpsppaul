package org.micap.jhoela.entitys;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The jhoel class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :26/03/2018
 */
@Document
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class jhoel {
    private String _id;
    private String nombre;

    /**
     * Sets the _id.
     *
     * @param _id the _id to set
     * @return jhoel
     */
    public jhoel set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the nombre.
     *
     * @param nombre the nombre to set
     * @return jhoel
     */
    public jhoel setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
