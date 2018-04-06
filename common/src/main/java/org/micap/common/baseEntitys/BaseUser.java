/**
 * The BaseUser class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :6/04/2018
 */
package org.micap.common.baseEntitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BaseUser {
    private String _id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;

    /**
     * Sets the _id.
     *
     * @param _id the _id to set
     * @return BaseUser
     */
    public BaseUser set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the firstName.
     *
     * @param firstName the firstName to set
     * @return BaseUser
     */
    public BaseUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the lastName.
     *
     * @param lastName the lastName to set
     * @return BaseUser
     */
    public BaseUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the birthDate.
     *
     * @param birthDate the birthDate to set
     * @return BaseUser
     */
    public BaseUser setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Sets the gender.
     *
     * @param gender the gender to set
     * @return BaseUser
     */
    public BaseUser setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
