package org.micap.user_management.dto;


import lombok.*;
import org.micap.common.entity.Function;
import org.micap.common.entity.Role;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Document

public class AccountWithoutPasswordDto {
    private String email;
    private String userName;
    private String roles[];
    private Function functions[];
}
