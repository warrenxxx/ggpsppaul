package org.micap.login_manage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.micap.common.entity.Account;
import org.micap.common.entity.Audit;
import org.micap.common.entity.Function;
import org.micap.common.entity.Role;
import org.micap.common.enums.Sexo;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * The UserDto class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :20/03/2018
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Document
public class UserDto {
    private String _id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Sexo gender;

    private String email;
    private String userName;
    private Role roles[];
    private Function functions[];
    private String token;

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
    public UserDto setGender(Sexo gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Sets the email.
     *
     * @param email the email to set
     * @return UserDto
     */
    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the userName.
     *
     * @param userName the userName to set
     * @return UserDto
     */
    public UserDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Sets the roles.
     *
     * @param roles the roles to set
     * @return UserDto
     */
    public UserDto setRoles(Role[] roles) {
        this.roles = roles;
        return this;
    }

    /**
     * Sets the functions.
     *
     * @param functions the functions to set
     * @return UserDto
     */
    public UserDto setFunctions(Function[] functions) {
        this.functions = functions;
        return this;
    }

    /**
     * Sets the token.
     *
     * @param token the token to set
     * @return UserDto
     */
    public UserDto setToken(String token) {
        this.token = token;
        return this;
    }
}
