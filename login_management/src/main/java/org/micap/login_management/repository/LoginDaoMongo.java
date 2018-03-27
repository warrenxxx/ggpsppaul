package org.micap.login_management.repository;

import org.micap.common.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * The LoginDao class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
public interface LoginDaoMongo extends  ReactiveMongoRepository<User,String>{
}
