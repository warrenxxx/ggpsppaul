package org.micap.login_management;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.micap.login_management.dto.LoginDto;
import org.micap.login_management.repository.LoginDaoMongoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import static org.micap.login_management.VariablesToTest.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("tst")
public class LoginDaoMongoImpTest {

    @Autowired
    LoginDaoMongoImp daoMongoImp;

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
    public void getFunctions() {
        StepVerifier.create(
                daoMongoImp.getFunctions(USER_A.get_id())
        ).expectNext(FUNCTION_USER_A).expectNextCount(0).verifyComplete();
        StepVerifier.create(
                daoMongoImp.getFunctions(USER_B.get_id())
        ).expectNext(FUNCTIONS_USER_B).expectNextCount(0).verifyComplete();
        StepVerifier.create(
                daoMongoImp.getFunctions(USER_C.get_id())
        ).expectNext(FUNCTIONS_USER_C).expectNextCount(0).verifyComplete();
    }
    @Test
    public void getUser() {
        StepVerifier.create(
                daoMongoImp.getUser(USER_A.getAccount().getUserName())
        ).expectNext(USER_A).verifyComplete();

        StepVerifier.create(
                daoMongoImp.getUser(USER_B.getAccount().getUserName())
        ).expectNext(USER_B).verifyComplete();

        StepVerifier.create(
                daoMongoImp.getUser(USER_C.getAccount().getUserName())
        ).expectNext(USER_C).verifyComplete();
    }

    @Test
    public void getUserDto(){
        StepVerifier.create(
                daoMongoImp
                        .getUserDto(new LoginDto(USER_A.getAccount().getUserName(),USER_A.getAccount().getPassword()))
                        .map(e->e.get_id())
        ).expectNext(USER_A.get_id()).verifyComplete();
        StepVerifier.create(
                daoMongoImp
                        .getUserDto(new LoginDto(USER_B.getAccount().getUserName(),USER_B.getAccount().getPassword()))
                        .map(e->e.get_id())
        ).expectNext(USER_B.get_id()).verifyComplete();
        StepVerifier.create(
                daoMongoImp
                        .getUserDto(new LoginDto(USER_C.getAccount().getUserName(),USER_C.getAccount().getPassword()))
                        .map(e->e.get_id())
        ).expectNext(USER_C.get_id()).verifyComplete();
    }
}