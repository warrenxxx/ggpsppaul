/**
 * The VariablesToTest class is implemment to
 *
 * @version :1.0
 * @Author :warre
 * @since :19/04/2018
 */
package org.micap.login_management;

import org.bson.types.ObjectId;
import org.micap.common.entity.Account;
import org.micap.common.entity.Function;
import org.micap.common.entity.Role;
import org.micap.common.entity.User;
import org.micap.login_management.dto.UserLoginDto;

import java.time.LocalDate;

public class VariablesToTest {

    /*
        Users
     */
    public static User USER_A = new User(
            "5ad9150619d2223b6cf04674",
            "warren",
            "aroni",
            LocalDate.now(),
            "MASCULINO",
            new Account(
                    "warren_as123@hotmail.com",
                    "123456",
                    "warrenxxx",
                    new String[]{"USER", "ADMIN"},
                    new Function[]{
                            new Function("5ad9150619d2223b6cf04683", "USER", new String[]{
                                    "UPDATE",
                                    "READ"
                            })
                    }

            ),
            null
    );
    public static User USER_B = new User(
            "5ad9150619d2223b6cf04675",
            "alicia",
            "torres",
            LocalDate.now(),
            "Femenino",
            new Account(
                    "sole_as123@hotmail.com",
                    "123456",
                    "solexxx",
                    new String[]{"USER"},
                    new Function[]{}
            ),
            null
    );
    public static User USER_C= new User(
            "5ad9150619d2223b6cf04678",
            "amir",
            "aroni",
            LocalDate.now(),
            "MASCULINO",
            new Account(
                    "AMIR_as123@hotmail.com",
                    "123456",
                    "AMIRxxx",
                    new String[]{"USER"},
                    new Function[]{
                            new Function("5ad9150619d2223b6cf04684", "USER", new String[]{
                                    "UPDATE"
                            })
                    }
            ),
            null
    );
    /*

        User Functions

     */
    public static String FUNCTION_USER_A="USER-CREATE," +
            "USER-READ," +
            "USER-UPDATE," +
            "USER-DELETE," +
            "ROLE-CREATE," +
            "ROLE-READ," +
            "ROLE-UPDATE," +
            "ROLE-DELETE," +
            "MICROLESSON-CREATE," +
            "MICROLESSON-READ," +
            "MICROLESSON-UPDATE," +
            "MICROLESSON-DELETE," +
            "VARIABLE-CREATE," +
            "VARIABLE-READ," +
            "VARIABLE-UPDATE," +
            "VARIABLE-DELETE," +
            "USER-UPDATE," +
            "USER-READ";
    public static String FUNCTIONS_USER_B="";
    public static String FUNCTIONS_USER_C="USER-UPDATE";

    /*

        Roles

     */

    public static Role ROLE_A=new Role(
            "USER",
            "User role",
            new Function[]{

            },
            true
    );

    public static Role ROLE_B=new Role(
            "ADMIN",
            "Aadmin roles",
            new Function[]{
                    new Function(
                            "5ad9150619d2223b6cf04678",
                            "USER",
                            new String[]{
                                    "CREATE",
                                    "READ",
                                    "UPDATE",
                                    "DELETE"
                            }
                    ),
                    new Function(
                            "5ad9150619d2223b6cf04679",
                            "ROLE",
                            new String[]{
                                    "CREATE",
                                    "READ",
                                    "UPDATE",
                                    "DELETE"
                            }
                    ),
                    new Function(
                            "5ad9150619d2223b6cf04680",
                            "MICROLESSON",
                            new String[]{
                                    "CREATE",
                                    "READ",
                                    "UPDATE",
                                    "DELETE"
                            }
                    ),
                    new Function(
                            "5ad9150619d2223b6cf04681",
                            "VARIABLE",
                            new String[]{
                                    "CREATE",
                                    "READ",
                                    "UPDATE",
                                    "DELETE"
                            }
                    ),
            },
            true
    );

    public static UserLoginDto USER_LOGIN_DTO_A=new UserLoginDto(
            USER_A.get_id(),
            USER_A.getFirstName(),
            USER_A.getLastName(),
            USER_A.getBirthDate(),
            USER_A.getGender(),
            USER_A.getAccount().getEmail(),
            USER_A.getAccount().getUserName(),
            new Role[]{
                    ROLE_A,
                    ROLE_B
            },
            USER_A.getAccount().getFunctions(),
            null
    );
    public static UserLoginDto USER_LOGIN_DTO_B=new UserLoginDto(
            USER_B.get_id(),
            USER_B.getFirstName(),
            USER_B.getLastName(),
            USER_B.getBirthDate(),
            USER_B.getGender(),
            USER_B.getAccount().getEmail(),
            USER_B.getAccount().getUserName(),
            new Role[]{
                    ROLE_A
            },
            USER_B.getAccount().getFunctions(),
            null
    );
    public static UserLoginDto USER_LOGIN_DTO_C=new UserLoginDto(
            USER_C.get_id(),
            USER_C.getFirstName(),
            USER_C.getLastName(),
            USER_C.getBirthDate(),
            USER_C.getGender(),
            USER_C.getAccount().getEmail(),
            USER_C.getAccount().getUserName(),
            new Role[]{
                    ROLE_A
            },
            USER_C.getAccount().getFunctions(),
            null
    );
}
