/**
 * The AppResponseDto class is implemment to
 *
 * @version :1.0
 * @Author :warre
 * @since :19/04/2018
 */
package org.micap.login_management;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.micap.common.config.AppError;
import org.micap.login_management.dto.UserLoginDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppResponseDto {
    public UserLoginDto data;
    public AppError error;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppResponseDto)) return false;

        AppResponseDto that = (AppResponseDto) o;

        if (getData() != null ? !getData().equals(that.getData()) : that.getData() != null) return false;
        return getError() != null ? getError().equals(that.getError()) : that.getError() == null;
    }

    @Override
    public int hashCode() {
        int result = getData() != null ? getData().hashCode() : 0;
        result = 31 * result + (getError() != null ? getError().hashCode() : 0);
        return result;
    }
}
