package org.micap.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * The Audit class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Document
public class Audit {

    private LocalDate createdLocalDate;
    private LocalDate modifiedLocalDate;
    private Object modifiedBy;
    private Object createdBy;

    /**
     * Sets the createdLocalDate.
     *
     * @param createdLocalDate the createdLocalDate to set
     * @return Audit
     */
    public Audit setCreatedLocalDate(LocalDate createdLocalDate) {
        this.createdLocalDate = createdLocalDate;
        return this;
    }

    /**
     * Sets the modifiedLocalDate.
     *
     * @param modifiedLocalDate the modifiedLocalDate to set
     * @return Audit
     */
    public Audit setModifiedLocalDate(LocalDate modifiedLocalDate) {
        this.modifiedLocalDate = modifiedLocalDate;
        return this;
    }

    /**
     * Sets the modifiedBy.
     *
     * @param modifiedBy the modifiedBy to set
     * @return Audit
     */
    public Audit setModifiedBy(Object modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    /**
     * Sets the createdBy.
     *
     * @param createdBy the createdBy to set
     * @return Audit
     */
    public Audit setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Audit(Object IdUser){
        this.createdLocalDate=LocalDate.now();
        this.modifiedLocalDate=LocalDate.now();
        this.modifiedBy=IdUser;
        this.createdBy=IdUser;
    }
}
