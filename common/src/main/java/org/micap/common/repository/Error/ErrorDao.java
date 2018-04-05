/**
 * The ErrorDao class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :4/04/2018
 */
package org.micap.common.repository.Error;

import org.micap.common.config.AppError;

public interface ErrorDao {
    public void saveError(AppError appError);
}
