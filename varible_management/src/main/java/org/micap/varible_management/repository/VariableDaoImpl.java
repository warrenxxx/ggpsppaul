package org.micap.varible_management.repository;

import org.micap.common.entity.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VariableDaoImpl implements VariableDao {

    @Autowired
    VariableDaoMongo variableDaoMongo;

    @Override
    public Mono<Variable> getVariable(String id) {
        return variableDaoMongo.findById(id);
    }

    @Override
    public Flux<Variable> getVariables() {
        return variableDaoMongo.findAll();
    }

    @Override
    public Mono<Variable> createVariable(Variable variable) {
        return variableDaoMongo.insert(variable);
    }

    @Override
    public Mono<Variable> updateVariable(Variable variable) {
        return variableDaoMongo.save(variable);
    }

    @Override
    public Mono<Void> deleteVariable(Variable variable) {
        return variableDaoMongo.delete(variable);
    }

    @Override
    public Mono<Void> deleteVariable(String id) {
        return variableDaoMongo.deleteById(id);
    }
}
