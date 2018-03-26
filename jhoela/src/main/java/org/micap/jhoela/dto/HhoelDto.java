package org.micap.jhoela.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The HhoelDto class is implemment to
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
public class HhoelDto {
    private String nombre;

    /**
     * Sets the nombre.
     *
     * @param nombre the nombre to set
     * @return HhoelDto
     */
    public HhoelDto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
