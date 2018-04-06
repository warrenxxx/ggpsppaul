package org.micap.user_management.dto;

import lombok.*;
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

    private String _id;
    private String firstName;
    private String lastName;
    private String gender;
    private Long roleCount;
    private Object age;
    private String email;
    private String userName;
    private Date birthDate;

    /**
     * Sets the birthDate.
     *
     * @param birthDate the birthDate to set
     * @return AllUserDto
     */
    public AllUserDto setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public AllUserDto(User user){
        this._id=user.get_id();
        this.firstName=user.getFirstName();
        this.lastName=user.getFirstName();

    }

    public AllUserDto setRoleCount(Long roleCount) {
        this.roleCount = roleCount;
        return this;
    }

    public AllUserDto setAge(Object age) {
        this.age = age;
        return this;
    }

    public AllUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public AllUserDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public AllUserDto setIdToString(){
        this._id=this._id.toString();
        return this;
    }

    /**
     * Sets the _id.
     *
     * @param _id the _id to set
     * @return UserDto
     */
    public AllUserDto set_id(String _id) {
        this._id = _id;
        return this;
    }

    /**
     * Sets the firstName.
     *
     * @param firstName the firstName to set
     * @return UserDto
     */
    public AllUserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the lastName.
     *
     * @param lastName the lastName to set
     * @return UserDto
     */
    public AllUserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }



    /**
     * Sets the gender.
     *
     * @param gender the gender to set
     * @return UserDto
     */
    public AllUserDto setGender(String gender) {
        this.gender = gender;
        return this;
    }


}
