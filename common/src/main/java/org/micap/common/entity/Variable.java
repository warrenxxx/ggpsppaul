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
public class Variable {
    private String _id;

    private String description;
    private String elements[];

    public Variable set_id(String _id) {
        this._id = _id;
        return this;
    }


    public Variable setDescription(String description) {
        this.description = description;
        return this;
    }

    public Variable setElements(String[] elements) {
        this.elements = elements;
        return this;
    }
}