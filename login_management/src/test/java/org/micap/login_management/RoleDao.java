package org.micap.login_management;

import org.micap.common.entity.Role;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoleDao extends ReactiveMongoRepository<Role,String> {
}
