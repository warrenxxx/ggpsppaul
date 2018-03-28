package org.micap.login_management.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The FunctionsDto class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :20/03/2018
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document
public class FunctionsDto {
    private String _id;
    private String []functions;
}
