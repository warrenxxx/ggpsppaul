package org.micap.common.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The response class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
@AllArgsConstructor
public class AppResponse {
    public final Object data;
    public final Error error;
}
