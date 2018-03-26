package org.micap.role_manage.repository;

import org.micap.common.entity.Role;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * The RoleDaoMongo class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
public interface RoleDaoMongo extends ReactiveMongoRepository<Role,String> {
}
