package org.micap.user_management.dto;

import lombok.*;
import org.micap.common.baseEntitys.BaseUser;
import org.micap.common.entity.User;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

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

public class AllUserDto {



    private Long roleCount;
    private Object age;
    private String email;
    private String userName;

    private BaseUser user;

    /**
     * Sets the roleCount.
     *
     * @param roleCount the roleCount to set
     * @return AllUserDto
     */
    public AllUserDto setRoleCount(Long roleCount) {
        this.roleCount = roleCount;
        return this;
    }

    /**
     * Sets the age.
     *
     * @param age the age to set
     * @return AllUserDto
     */
    public AllUserDto setAge(Object age) {
        this.age = age;
        return this;
    }

    /**
     * Sets the email.
     *
     * @param email the email to set
     * @return AllUserDto
     */
    public AllUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the userName.
     *
     * @param userName the userName to set
     * @return AllUserDto
     */
    public AllUserDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Sets the user.
     *
     * @param user the user to set
     * @return AllUserDto
     */
    public AllUserDto setUser(BaseUser user) {
        this.user = user;
        return this;
    }
}
