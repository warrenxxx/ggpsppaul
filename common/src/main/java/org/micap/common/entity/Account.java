package org.micap.common.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Account class is implemment to
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
@EqualsAndHashCode
public class Account {
    private String email;
    private String password;
    private String userName;
    private String roles[];
    private Function functions[];


    /**
     * Sets the email.
     *
     * @param email the email to set
     * @return Account
     */
    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the userName.
     *
     * @param userName the userName to set
     * @return Account
     */
    public Account setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set
     * @return Account
     */
    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

        /**
     * Sets the roles.
     *
     * @param roles the roles to set
     * @return Account
     */
    public Account setRoles(String [] roles) {
        this.roles = roles;
        return this;
    }

    /**
     * Sets the functions.
     *
     * @param functions the functions to set
     * @return Account
     */
    public Account setFunctions(Function[] functions) {
        this.functions = functions;
        return this;
    }


}
