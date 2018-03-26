package org.micap.login_manage.dto;

import lombok.Data;
import org.micap.common.config.AppError;

/**
 * The LoginResponse class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :24/03/2018
 */
@Data
public class LoginResponse {
    public UserDto loginDto;
}
