package org.micap.common.config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import lombok.*;
import org.micap.common.entity.User;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

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
public class Token {
    private String token;

    public Token setToken(String token) {
        this.token = token;
        return this;
    }
    public Token setToken(User user) {

        return this;
    }
    public Token getToken(HashMap map) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");

            String token = JWT
                    .create()
                    .withHeader(map)
                    .sign(algorithm);

            return new Token(token);
        } catch (UnsupportedEncodingException exception){
            return new Token();
        } catch (JWTCreationException exception){
            return new Token();
        }
    }



}
