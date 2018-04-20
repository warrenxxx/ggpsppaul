package org.micap.login_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The LoginDto class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :20/03/2018
 */

@AllArgsConstructor
@NoArgsConstructor

public class LoginDto {
    @Getter private String user;
    @Getter private String password;

    /**
     * Sets the LoginDto.
     *
     * @param user the user to set
     * @return LoginDto
     */
    public LoginDto setUser(String user) {
        this.user = user;
        return this;
    }

    /**
     * Sets the LoginDto.
     *
     * @param password the password to set
     * @return LoginDto
     */
    public LoginDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
