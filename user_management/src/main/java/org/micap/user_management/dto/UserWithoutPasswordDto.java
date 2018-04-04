package org.micap.user_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.micap.common.entity.Account;
import org.micap.common.entity.Audit;
import org.micap.common.enums.Sexo;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

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
public class UserWithoutPasswordDto {
    private String _id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Sexo gender;
    private AccountWithoutPasswordDto account;
    private Object age;

    public UserWithoutPasswordDto setAge(Object age) {
        this.age = age;
        return this;
    }

    /**
     * Sets the _id.
     *
     * @param _id the _id to set
     * @return User
     */
    public UserWithoutPasswordDto set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the firstName.
     *
     * @param firstName the firstName to set
     * @return User
     */
    public UserWithoutPasswordDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the lastName.
     *
     * @param lastName the lastName to set
     * @return User
     */
    public UserWithoutPasswordDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the birthDate.
     *
     * @param birthDate the birthDate to set
     * @return User
     */
    public UserWithoutPasswordDto setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Sets the gender.
     *
     * @param gender the gender to set
     * @return User
     */
    public UserWithoutPasswordDto setGender(Sexo gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Sets the account.
     *
     * @param account the account to set
     * @return User
     */
    public UserWithoutPasswordDto setAccount(AccountWithoutPasswordDto account) {
        this.account = account;
        return this;
    }

}

