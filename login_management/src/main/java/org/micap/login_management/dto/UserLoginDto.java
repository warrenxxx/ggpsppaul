package org.micap.login_management.dto;

import lombok.*;
import org.micap.common.entity.Function;
import org.micap.common.entity.Role;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * The UserLoginDto class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :20/03/2018
 */

@AllArgsConstructor
@NoArgsConstructor

public class UserLoginDto {

    @Getter private String _id;
    @Getter private String firstName;
    @Getter private String lastName;
    @Getter private LocalDate birthDate;
    @Getter private String gender;
    @Getter private String email;
    @Getter private String userName;
    @Getter private Role roles[];
    @Getter private Function functions[];
    @Getter private String token;

    /**
     * Sets the UserLoginDto.
     *
     * @param _id the _id to set
     * @return UserLoginDto
     */
    public UserLoginDto set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the UserLoginDto.
     *
     * @param firstName the firstName to set
     * @return UserLoginDto
     */
    public UserLoginDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the UserLoginDto.
     *
     * @param lastName the lastName to set
     * @return UserLoginDto
     */
    public UserLoginDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the UserLoginDto.
     *
     * @param birthDate the birthDate to set
     * @return UserLoginDto
     */
    public UserLoginDto setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Sets the UserLoginDto.
     *
     * @param gender the gender to set
     * @return UserLoginDto
     */
    public UserLoginDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Sets the email.
     *
     * @param email the email to set
     * @return UserLoginDto
     */
    public UserLoginDto setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the userName.
     *
     * @param userName the userName to set
     * @return UserLoginDto
     */
    public UserLoginDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Sets the roles.
     *
     * @param roles the roles to set
     * @return UserLoginDto
     */
    public UserLoginDto setRoles(Role[] roles) {
        this.roles = roles;
        return this;
    }

    /**
     * Sets the functions.
     *
     * @param functions the functions to set
     * @return UserLoginDto
     */
    public UserLoginDto setFunctions(Function[] functions) {
        this.functions = functions;
        return this;
    }

    /**
     * Sets the token.
     *
     * @param token the token to set
     * @return UserLoginDto
     */
    public UserLoginDto setToken(String token) {
        this.token = token;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserLoginDto)) return false;

        UserLoginDto that = (UserLoginDto) o;

        if (get_id() != null ? !get_id().equals(that.get_id()) : that.get_id() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        if (getBirthDate() != null ? !getBirthDate().equals(that.getBirthDate()) : that.getBirthDate() != null)
            return false;
        if (getGender() != null ? !getGender().equals(that.getGender()) : that.getGender() != null) return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getUserName() != null ? !getUserName().equals(that.getUserName()) : that.getUserName() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getRoles(), that.getRoles())) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getFunctions(), that.getFunctions())) return false;
        return getToken() != null ? getToken().equals(that.getToken()) : that.getToken() == null;
    }

}
