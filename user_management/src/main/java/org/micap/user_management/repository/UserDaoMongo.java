package org.micap.user_management.repository;

import org.micap.common.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The UserDao class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
public interface UserDaoMongo extends  ReactiveMongoRepository<User,String>{

}
