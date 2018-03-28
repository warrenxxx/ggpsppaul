package org.micap.role_management.repository;

import org.micap.common.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
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
public class RoleDaoImp implements RoleDao{

    @Autowired
    public RoleDaoMongo roleDaoMongo;


    @Autowired
    public ReactiveMongoOperations reactiveMongoOperations;

    public Flux<Role> getRoles(){
        return roleDaoMongo.findAll();
    }

    public Mono<Role> getRole(String id){
        return roleDaoMongo.findById(id);
    }

    public Mono<Role> CreateRole(Role role){
        return roleDaoMongo.save(role);
    }

    public Mono<Role> UpdataRole(Role role){
        return roleDaoMongo.save(role);
    }
    public Mono<Void> DeleteRole(Role role){
        return roleDaoMongo.delete(role);
    }
    public Mono<Void> DeleteRoleById(String id){
        return roleDaoMongo.deleteById(id);
    }

    @Override
    public Mono<Boolean> existById(String id) {
        return roleDaoMongo.existsById(id);
    }

}
