/**
 * The dtosTest class is implemment to
 *
 * @version :1.0
 * @Author :warre
 * @since :19/04/2018
 */
package org.micap.login_management;

import org.junit.Before;
import org.junit.Test;
import org.micap.common.entity.Function;
import org.micap.common.entity.Role;
import org.micap.login_management.dto.FunctionsDto;
import org.micap.login_management.dto.LoginDto;
import org.micap.login_management.dto.UserLoginDto;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class dtosTest {

    FunctionsDto functionsDto;
    LoginDto loginDto;
    UserLoginDto userLoginDto;

    LocalDate localDate=LocalDate.now();

    @Before
    public void before(){
        this.functionsDto=new FunctionsDto("USER",new String[]{
                "UPDATE",
                "CREATE"
        });
        this.loginDto=new LoginDto("warrenxxx","123456");
        this.userLoginDto=new UserLoginDto(
                "id",
                "first",
                "last",
                localDate,
                "gender",
                "warren_as@",
                "warrenxxx",
                new Role[]{},
                new Function[]{},
                ""
        );
    }


    @Test
    public void FunctionDto(){
        FunctionsDto functionsDtoTest=new FunctionsDto();
        functionsDtoTest.set_id("USER");
        functionsDtoTest.setFunctions(new String[]{
                "UPDATE",
                "CREATE"
        });
        assertEquals(functionsDto.get_id(),functionsDtoTest.get_id());
        assertArrayEquals(functionsDtoTest.getFunctions(),functionsDto.getFunctions());
    }
    @Test
    public void loginDto(){
        LoginDto loginDtotest=new LoginDto();
        loginDtotest.setPassword("123456");
        loginDtotest.setUser("warrenxxx");
        loginDtotest.getClass();
        assertEquals(loginDto.getPassword(),loginDtotest.getPassword());
        assertEquals(loginDto.getUser(),loginDtotest.getUser());
    }
    @Test
    public void userLoginDto(){
        UserLoginDto userLoginDtoTest=new UserLoginDto();
        userLoginDtoTest.setToken("");
        userLoginDtoTest.setEmail("warren_as@");
        userLoginDtoTest.setFunctions(new Function[]{});
        userLoginDtoTest.setRoles(new Role[]{});
        userLoginDtoTest.setUserName("warrenxxx");
        userLoginDtoTest.setBirthDate(localDate);
        userLoginDtoTest.setFirstName("first");
        userLoginDtoTest.setLastName("last");
        userLoginDtoTest.set_id("id");
        userLoginDtoTest.setGender("gender");

//        assertEquals(userLoginDtoTest.hashCode(),userLoginDto.hashCode());
        assertEquals(
                userLoginDtoTest.get_id(),
                userLoginDto.get_id()
        );
        assertEquals(
                userLoginDtoTest.getUserName(),
                userLoginDto.getUserName()
        );
        assertEquals(
                userLoginDtoTest.getEmail(),
                userLoginDto.getEmail()
        );
        assertEquals(
                userLoginDtoTest.getFirstName(),
                userLoginDto.getFirstName()
        );
        assertEquals(
                userLoginDtoTest.getGender(),
                userLoginDto.getGender()
        );
        assertEquals(
                userLoginDtoTest.getLastName(),
                userLoginDto.getLastName()
        );
        assertEquals(
                userLoginDtoTest.getToken(),
                userLoginDto.getToken()
        );
        assertEquals(
                userLoginDtoTest.getBirthDate(),
                userLoginDto.getBirthDate()
        );
        assertArrayEquals(
                userLoginDtoTest.getFunctions(),
                userLoginDto.getFunctions()
        );
        assertArrayEquals(
                userLoginDtoTest.getRoles(),
                userLoginDto.getRoles()
        );
        assertEquals(userLoginDtoTest,userLoginDto);

        UserLoginDto fail=new UserLoginDto();
        assertNotEquals(
                userLoginDtoTest.get_id(),
                fail.get_id()
        );
        assertNotEquals(
                userLoginDtoTest.getUserName(),
                fail.getUserName()
        );
        assertNotEquals(
                userLoginDtoTest.getEmail(),
                fail.getEmail()
        );
        assertNotEquals(
                userLoginDtoTest.getFirstName(),
                fail.getFirstName()
        );
        assertNotEquals(
                userLoginDtoTest.getGender(),
                fail.getGender()
        );
        assertNotEquals(
                userLoginDtoTest.getLastName(),
                fail.getLastName()
        );
        assertNotEquals(
                userLoginDtoTest.getToken(),
                fail.getToken()
        );
        assertNotEquals(
                userLoginDtoTest.getBirthDate(),
                fail.getBirthDate()
        );
        assertArrayEquals(
                null,
                fail.getFunctions()
        );
        assertArrayEquals(
                null,
                fail.getRoles()
        );

    }

}
