package org.micap.varible_management.repository;

import org.micap.common.entity.Variable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VariableDaoMongo extends ReactiveMongoRepository<Variable,String> {
}
