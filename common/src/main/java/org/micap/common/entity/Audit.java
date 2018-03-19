package org.micap.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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

    private Date createdDate;
    private Date modifiedDate;
    private Object modifiedBy;
    private Object createdBy;




    /**
     * Sets the createdDate.
     *
     * @param createdDate the createdDate to set
     * @return Audit
     */
    public Audit setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * Sets the modifiedDate.
     *
     * @param modifiedDate the modifiedDate to set
     * @return Audit
     */
    public Audit setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
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
        this.createdDate=new Date();
        this.modifiedDate=new Date();
        this.modifiedBy=IdUser;
        this.createdBy=IdUser;
    }
}
