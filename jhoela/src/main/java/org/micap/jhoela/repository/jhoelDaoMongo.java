package org.micap.jhoela.repository;

import org.micap.jhoela.entitys.jhoel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * The jhoelDaoMongo class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :26/03/2018
 */
public interface jhoelDaoMongo extends ReactiveMongoRepository<jhoel,String>{
}
