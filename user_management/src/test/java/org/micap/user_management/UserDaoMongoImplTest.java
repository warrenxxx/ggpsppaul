package org.micap.user_management;

import org.micap.user_management.repository.UserDaoMongoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("tst")
public class UserDaoMongoImplTest {

    @Autowired
    UserDaoMongoImp userDaoMongoImp;

}
