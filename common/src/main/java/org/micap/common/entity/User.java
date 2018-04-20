package org.micap.common.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * The User class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :17/03/2018
 */

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class User{
    private String _id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;

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
    public User setGender(String gender) {
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
    public User updateAudit(String id){
        return this.setAudit(this.getAudit().update(id));
    }



    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (audit != null ? audit.hashCode() : 0);
        return result;
    }
    /*
this Override is generate to intellij
 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (get_id() != null ? !get_id().equals(user.get_id()) : user.get_id() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (getBirthDate() != null ? !getBirthDate().equals(user.getBirthDate()) : user.getBirthDate() != null)
            return false;
        if (getGender() != null ? !getGender().equals(user.getGender()) : user.getGender() != null) return false;
        if (getAccount() != null ? !getAccount().equals(user.getAccount()) : user.getAccount() != null) return false;
        return getAudit() != null ? getAudit().equals(user.getAudit()) : user.getAudit() == null;
    }
}
