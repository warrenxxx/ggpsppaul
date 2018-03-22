package org.micap.common.entity;

import lombok.*;
import org.micap.common.enums.Sexo;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

/**
 * The User class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :17/03/2018
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Document
public class User {
    private String _id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Sexo gender;
    private Account account;
    private Audit audit;

    /**
     * Sets the _id.
     *
     * @param _id the _id to set
     * @return User
     */
    public User set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the firstName.
     *
     * @param firstName the firstName to set
     * @return User
     */
    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the lastName.
     *
     * @param lastName the lastName to set
     * @return User
     */
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the birthDate.
     *
     * @param birthDate the birthDate to set
     * @return User
     */
    public User setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Sets the gender.
     *
     * @param gender the gender to set
     * @return User
     */
    public User setGender(Sexo gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Sets the account.
     *
     * @param account the account to set
     * @return User
     */
    public User setAccount(Account account) {
        this.account = account;
        return this;
    }

    /**
     * Sets the audit.
     *
     * @param audit the audit to set
     * @return User
     */
    public User setAudit(Audit audit) {
        this.audit = audit;
        return this;
    }

    public User newAudit(){
        return this.setAudit(new Audit(get_id()));
    }
}
