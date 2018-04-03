package org.micap.user_management;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.micap.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagementApplicationTests {

    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() {
        System.out.println(
                StepVerifier.create(reactiveMongoTemplate.dropCollection(User.class)).verifyComplete()
        );
    }
}
