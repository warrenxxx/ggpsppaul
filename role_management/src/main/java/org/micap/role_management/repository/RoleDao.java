package org.micap.role_management.repository;

import org.micap.common.entity.Role;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The RoleDao1 class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :20/03/2018
 */
public interface RoleDao {
    public Flux<Role> getRoles();

    public Mono<Role> getRole(String id);

    public Mono<Role> CreateRole(Role role);

    public Mono<Role> UpdataRole(Role role);
    public Mono<Void> DeleteRole(Role role);
    public Mono<Void> DeleteRoleById(String id);
    public Mono<Boolean> existById(String id);
    public Flux<String> getEntitis();
}
