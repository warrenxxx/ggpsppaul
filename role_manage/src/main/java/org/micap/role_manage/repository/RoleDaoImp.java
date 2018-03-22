package org.micap.role_manage.repository;

import org.bson.types.ObjectId;
import org.micap.common.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The RoleDaoImp class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
@Service
public class RoleDaoImp {

    @Autowired
    public RoleDao roleDao;


    @Autowired
    public ReactiveMongoOperations reactiveMongoOperations;

    public Flux<Role> getRoles(){
        return roleDao.findAll();
    }

    public Mono<Role> getRole(String id){
        return roleDao.findById(id);
    }

    public Mono<Role> CreateRole(Role role){
        return roleDao.save(role);
    }

    public Mono<Role> UpdataRole(Role role){
        return roleDao.save(role);
    }
    public Mono<Void> DeleteRole(Role role){
        return roleDao.delete(role);
    }
    public Mono<Void> DeleteRoleById(String id){
        return roleDao.deleteById(id);
    }

}
