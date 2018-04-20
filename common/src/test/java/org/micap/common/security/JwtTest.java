package org.micap.common.security;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRange;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyExtractor;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.Principal;
import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class JwtTest {

    private String jwtStr="eyJ0eXAiOiJKV1QiLCJfaWQiOiI1YWQ4ZTBkMDE5ZDIyMjIzZGM5NzgwM2QiLCJmdW5jdGlvbnMiOiJVU0VSX0NSRUFURSIsImFsZyI6IkhTMjU2In0.eyJpc3MiOiJhdXRoMCJ9.BNkpAMnAEAsAkN1Bl8gFjvlxcsQI6_aRO4pCS7TushY",
            id="5ad8e0d019d22223dc97803d",
            functions="USER_CREATE";


    private ServerRequest req;



    @Autowired
    private WebTestClient webTestClient;

    @Before
    void before(){
        req=new ServerRequest() {
            @Override
            public String methodName() {
                return null;
            }

            @Override
            public URI uri() {
                return null;
            }

            @Override
            public UriBuilder uriBuilder() {
                return null;
            }

            @Override
            public Headers headers() {
                return new Headers() {
                    @Override
                    public List<MediaType> accept() {
                        return null;
                    }

                    @Override
                    public List<Charset> acceptCharset() {
                        return null;
                    }

                    @Override
                    public List<Locale.LanguageRange> acceptLanguage() {
                        return null;
                    }

                    @Override
                    public OptionalLong contentLength() {
                        return null;
                    }

                    @Override
                    public Optional<MediaType> contentType() {
                        return Optional.empty();
                    }

                    @Override
                    public InetSocketAddress host() {
                        return null;
                    }

                    @Override
                    public List<HttpRange> range() {
                        return null;
                    }

                    @Override
                    public List<String> header(String s) {
                        if(s=="Authorization")
                         return asList(jwtStr);
                        return asList();
                    }

                    @Override
                    public HttpHeaders asHttpHeaders() {
                        return null;
                    }
                };
            }

            @Override
            public MultiValueMap<String, HttpCookie> cookies() {
                return null;
            }

            @Override
            public <T> T body(BodyExtractor<T, ? super ServerHttpRequest> bodyExtractor) {
                return null;
            }

            @Override
            public <T> T body(BodyExtractor<T, ? super ServerHttpRequest> bodyExtractor, Map<String, Object> map) {
                return null;
            }

            @Override
            public <T> Mono<T> bodyToMono(Class<? extends T> aClass) {
                return null;
            }

            @Override
            public <T> Mono<T> bodyToMono(ParameterizedTypeReference<T> parameterizedTypeReference) {
                return null;
            }

            @Override
            public <T> Flux<T> bodyToFlux(Class<? extends T> aClass) {
                return null;
            }

            @Override
            public <T> Flux<T> bodyToFlux(ParameterizedTypeReference<T> parameterizedTypeReference) {
                return null;
            }

            @Override
            public Map<String, Object> attributes() {
                return null;
            }

            @Override
            public MultiValueMap<String, String> queryParams() {
                return null;
            }

            @Override
            public Map<String, String> pathVariables() {
                return null;
            }

            @Override
            public Mono<WebSession> session() {
                return null;
            }

            @Override
            public Mono<? extends Principal> principal() {
                return null;
            }
        };
    }

    @Test
    void toJwt() {
        Assert.assertEquals(jwtStr,
                Jwt.toJwt(id,functions));
    }

    @Test
    void verifyFunctions() {

    }

    @Test
    void getIdOfJwtToken() {


    }
}