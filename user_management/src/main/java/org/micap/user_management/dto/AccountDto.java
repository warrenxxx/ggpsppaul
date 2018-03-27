package org.micap.user_management.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 1/03/2018
 * Time: 10:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Document
public class AccountDto {
    private String email;
    private String userName;
    private String passsword;

    /**
     * Sets the email.
     *
     * @param email the email to set
     * @return AccountDto
     */
    public AccountDto setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the userName.
     *
     * @param userName the userName to set
     * @return AccountDto
     */
    public AccountDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Sets the passsword.
     *
     * @param passsword the passsword to set
     * @return AccountDto
     */
    public AccountDto setPasssword(String passsword) {
        this.passsword = passsword;
        return this;
    }
}
