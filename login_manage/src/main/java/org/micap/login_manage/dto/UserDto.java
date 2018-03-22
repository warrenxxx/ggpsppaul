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
}
