package org.micap.common.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@ToString
@EqualsAndHashCode
@Document
public class Function {
    public String _id;
    public String entity;
    public String crudMethods[];

    /**
     * Sets the _id.
     *
     * @param _id the _id to set
     * @return Function
     */
    public Function set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the entity.
     *
     * @param entity the entity to set
     * @return Function
     */
    public Function setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    /**
     * Sets the crudMethods.
     *
     * @param crudMethods the crudMethods to set
     * @return Function
     */
    public Function setCrudMethods(String[] crudMethods) {
        this.crudMethods = crudMethods;
        return this;
    }
}
