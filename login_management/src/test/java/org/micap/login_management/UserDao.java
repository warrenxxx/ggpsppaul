package org.micap.login_management;

import org.micap.common.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserDao extends ReactiveMongoRepository<User,String > {
}
