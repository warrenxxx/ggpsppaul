package org.micap.user_management;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.micap.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
public class UserManagementApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void test1() {

        EntityExchangeResult<String> result =
                webTestClient.get().uri("/user")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult();
        System.out.println(result.getResponseBody());
        assertEquals(result.getResponseBody(), "{\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"roleCount\": 2,\n" +
                "            \"age\": 0,\n" +
                "            \"email\": \"warren_as12342@hotmail.com\",\n" +
                "            \"userName\": \"test\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ac4fb72a9641d307475cc35\",\n" +
                "                \"firstName\": \"warrenwarre\",\n" +
                "                \"lastName\": \"aroni2\",\n" +
                "                \"birthDate\": \"2018-01-01\",\n" +
                "                \"gender\": \"MASCULINO\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleCount\": 2,\n" +
                "            \"age\": 23,\n" +
                "            \"email\": \"jhoana@hotmail.com\",\n" +
                "            \"userName\": \"jhoanaxxx\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ac4fc40a9641d307475cc36\",\n" +
                "                \"firstName\": \"jhoana\",\n" +
                "                \"lastName\": \"champi\",\n" +
                "                \"birthDate\": \"1995-01-01\",\n" +
                "                \"gender\": \"FEMENINO\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleCount\": 1,\n" +
                "            \"age\": 23,\n" +
                "            \"email\": \"guffy@hotmail.com\",\n" +
                "            \"userName\": \"paulinaxxx\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ac4fc9aa9641d307475cc37\",\n" +
                "                \"firstName\": \"paulina\",\n" +
                "                \"lastName\": \"guffy alias guffy\",\n" +
                "                \"birthDate\": \"1995-01-01\",\n" +
                "                \"gender\": \"FEMENINO\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleCount\": 1,\n" +
                "            \"age\": 4,\n" +
                "            \"email\": \"test1@gmail.com\",\n" +
                "            \"userName\": \"test1\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ac4fcda607bed43404ad05d\",\n" +
                "                \"firstName\": \"test\",\n" +
                "                \"lastName\": \"testAp\",\n" +
                "                \"birthDate\": \"2014-02-03\",\n" +
                "                \"gender\": \"FEMENINO\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleCount\": 1,\n" +
                "            \"age\": 21,\n" +
                "            \"email\": \"test2@gmail.com\",\n" +
                "            \"userName\": \"test2\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ac4fd72607bed43404ad05e\",\n" +
                "                \"firstName\": \"test2\",\n" +
                "                \"lastName\": \"testAp2\",\n" +
                "                \"birthDate\": \"1997-04-05\",\n" +
                "                \"gender\": \"MASCULINO\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleCount\": 2,\n" +
                "            \"age\": 21,\n" +
                "            \"email\": \"admin@admin.com\",\n" +
                "            \"userName\": \"admin\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ac4fd95607bed43404ad05f\",\n" +
                "                \"firstName\": \"administrador\",\n" +
                "                \"lastName\": \"elmaspro\",\n" +
                "                \"birthDate\": \"1996-05-19\",\n" +
                "                \"gender\": \"FEMENINO\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleCount\": 1,\n" +
                "            \"age\": 4,\n" +
                "            \"email\": \"test100@gmail.com\",\n" +
                "            \"userName\": \"tes100\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ac508d51196dd0d9c5a9005\",\n" +
                "                \"firstName\": \"test100\",\n" +
                "                \"lastName\": \"testAp100\",\n" +
                "                \"birthDate\": \"2014-03-05\",\n" +
                "                \"gender\": \"MASCULINO\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleCount\": 2,\n" +
                "            \"age\": 21,\n" +
                "            \"email\": \"test101@gmail.com\",\n" +
                "            \"userName\": \"tes101\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ac509051196dd0d9c5a9006\",\n" +
                "                \"firstName\": \"test101\",\n" +
                "                \"lastName\": \"testAp101\",\n" +
                "                \"birthDate\": \"1997-02-05\",\n" +
                "                \"gender\": \"FEMENINO\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleCount\": 1,\n" +
                "            \"age\": 19,\n" +
                "            \"email\": \"test102@gmail.com\",\n" +
                "            \"userName\": \"tes102\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ac5092c1196dd0d9c5a9007\",\n" +
                "                \"firstName\": \"test102\",\n" +
                "                \"lastName\": \"testAp102\",\n" +
                "                \"birthDate\": \"1999-02-05\",\n" +
                "                \"gender\": \"MASCULINO\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleCount\": 1,\n" +
                "            \"age\": 23,\n" +
                "            \"email\": \"guffy@hotmail.com\",\n" +
                "            \"userName\": \"paulinaxxxx\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ac50b98a9641d307475cc39\",\n" +
                "                \"firstName\": \"paulina\",\n" +
                "                \"lastName\": \"guffy alias guffy\",\n" +
                "                \"birthDate\": \"1995-01-01\",\n" +
                "                \"gender\": \"FEMENINO\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleCount\": 1,\n" +
                "            \"age\": 0,\n" +
                "            \"email\": \"test200@gmailc.com\",\n" +
                "            \"userName\": \"test200\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ac7880e5f16b73ce87fbf3b\",\n" +
                "                \"firstName\": \"test200\",\n" +
                "                \"lastName\": \"test200 apppellido\",\n" +
                "                \"birthDate\": \"2018-01-01\",\n" +
                "                \"gender\": \"MASCULINO\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roleCount\": 1,\n" +
                "            \"age\": 0,\n" +
                "            \"email\": \"test2000@gmailc.com\",\n" +
                "            \"userName\": \"test2000\",\n" +
                "            \"user\": {\n" +
                "                \"_id\": \"5ace211c5cab570768b71d2c\",\n" +
                "                \"firstName\": \"test2000\",\n" +
                "                \"lastName\": \"test2000 app\",\n" +
                "                \"birthDate\": \"2018-01-01\",\n" +
                "                \"gender\": \"MASCULINO\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"error\": null\n" +
                "}");

    }

    @Test
    public void test2() {
        webTestClient.get().uri("/user")
                .exchange()
                .expectStatus().isOk();
    }
}
