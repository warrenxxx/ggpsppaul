package org.micap.common.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Document
public class Role {
    public String _id;
    public String description;
    public Function functions[];

    /**
     * Sets the _id.
     *
     * @param _id the _id to set
     * @return Role
     */
    public Role set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the descripcion.
     *
     * @param descripcion the descripcion to set
     * @return Role
     */
    public Role setDescripcion(String descripcion) {
        this.description = descripcion;
        return this;
    }

    /**
     * Sets the functions.
     *
     * @param functions the functions to set
     * @return Role
     */
    public Role setFunctions(Function[] functions) {
        this.functions = functions;
        return this;
    }

    public Role setIdToString() {
        this._id=this._id.toString();
        return this;
    }
}
