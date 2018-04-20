/**
 * The FunctionsDto class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :5/04/2018
 */

package org.micap.login_management.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

/**
 * The FunctionsDto class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :20/03/2018
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FunctionsDto {
    private String _id;
    private String []functions;

}
