package org.micap.varible_management.repository;


import org.micap.common.entity.Variable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VariableDao {
    public Mono<Variable> getVariable(String id);
    public Flux<Variable> getVariables();
    public Mono<Variable> createVariable(Variable variable);
    public Mono<Variable> updateVariable(Variable variable);
    public Mono<Void> deleteVariable(Variable variable);
    public Mono<Void> deleteVariable(String id);
}

