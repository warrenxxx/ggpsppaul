package org.micap.user_manage.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Data
@ToString
@EqualsAndHashCode
@Document

public class UserDto {
    private Object _id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private AccountDto account;
    public UserDto setIdToString(){
        this._id=this._id.toString();
        return this;
    }
}
