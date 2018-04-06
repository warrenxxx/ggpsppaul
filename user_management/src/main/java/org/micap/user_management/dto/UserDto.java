package org.micap.user_management.dto;

import lombok.*;
import org.micap.common.entity.User;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 28/02/2018
 * Time: 21:20
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Document

public class UserDto {

    private String _id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private AccountDto account;
    private Long roleCount;
    private Long age;

    public UserDto(User user){
        this._id=user.get_id();
        this.firstName=user.getFirstName();
        this.lastName=user.getFirstName();

    }

    public UserDto setIdToString(){
        this._id=this._id.toString();
        return this;
    }

    /**
     * Sets the _id.
     *
     * @param _id the _id to set
     * @return UserDto
     */
    public UserDto set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the firstName.
     *
     * @param firstName the firstName to set
     * @return UserDto
     */
    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the lastName.
     *
     * @param lastName the lastName to set
     * @return UserDto
     */
    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the birthDate.
     *
     * @param birthDate the birthDate to set
     * @return UserDto
     */
    public UserDto setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Sets the gender.
     *
     * @param gender the gender to set
     * @return UserDto
     */
    public UserDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Sets the account.
     *
     * @param account the account to set
     * @return UserDto
     */
    public UserDto setAccount(AccountDto account) {
        this.account = account;
        return this;
    }
}
