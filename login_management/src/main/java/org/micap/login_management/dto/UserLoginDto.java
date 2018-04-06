package org.micap.login_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.micap.common.entity.Function;
import org.micap.common.entity.Role;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * The UserLoginDto class is implemment to
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
public class UserLoginDto {

    private String _id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private String email;
    private String userName;
    private Role roles[];
    private Function functions[];
    private String token;


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
}
