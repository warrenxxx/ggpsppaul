package org.micap.user_manage.repository;

import org.bson.types.ObjectId;
import org.micap.common.entity.User;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * The UserDao class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
public interface UserDao extends ReactiveMongoRepository<User,ObjectId> {
}
