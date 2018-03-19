package org.micap.user_manage.dto;

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
@Data
@ToString
@EqualsAndHashCode
@Document
public class AccountDto {
    private String email;
    private String userName;
}
