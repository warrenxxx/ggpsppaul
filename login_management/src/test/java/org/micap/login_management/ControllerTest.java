/**
 * The ControllerTest class is implemment to
 *
 * @version :1.0
 * @Author :warre
 * @since :19/04/2018
 */
package org.micap.login_management;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.micap.login_management.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.micap.login_management.VariablesToTest.*;
import static org.micap.login_management.VariablesToTest.ROLE_A;
import static org.micap.login_management.VariablesToTest.ROLE_B;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("tst")
public class ControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    public UserDao userDao;

    @Autowired
    public RoleDao roleDao;

    @Before
    public void brefore(){

        StepVerifier.create(userDao.deleteAll()).expectNextCount(0).verifyComplete();
        StepVerifier.create(
                userDao.insert(USER_A)
        ).expectNextCount(1).verifyComplete();
        StepVerifier.create(
                userDao.insert(USER_B)
        ).expectNextCount(1).verifyComplete();

        StepVerifier.create(
                userDao.insert(USER_C)
        ).expectNextCount(1).verifyComplete();
        StepVerifier.create(roleDao.deleteAll()).expectNextCount(0).verifyComplete();
        StepVerifier.create(
                roleDao.insert(ROLE_A)
        ).expectNextCount(1).verifyComplete();
        StepVerifier.create(
                roleDao.insert(ROLE_B)
        ).expectNextCount(1).verifyComplete();
    }
    @Test
    public void test1() {
        EntityExchangeResult<AppResponseDto> result=
                webTestClient.post().uri("/login")
                .body(Mono.just(new LoginDto("warrenxxx", "123456")), LoginDto.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(AppResponseDto.class)
                .returnResult()
        ;


        assertEquals((result.getResponseBody().data).setToken(null),USER_LOGIN_DTO_A);


    }
}
