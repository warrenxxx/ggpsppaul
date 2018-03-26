package org.micap.jhoela.repository;

import org.micap.jhoela.dto.HhoelDto;
import org.micap.jhoela.entitys.jhoel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The jhoelDaoImpl class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :26/03/2018
 */
@Service
public class jhoelDaoImpl implements jhoelDao {

    @Autowired
    jhoelDaoMongo jhoelDaoMongo;

    @Override
    public Flux<HhoelDto> getJhoels() {
        return jhoelDaoMongo
                .findAll()
                .map(e->new HhoelDto(e.getNombre()));
    }

    @Override
    public Mono<HhoelDto> getJhoel(String id) {
            return jhoelDaoMongo
                    .findById(id)
                    .map(e->new HhoelDto(e.getNombre()));
    }

    @Override
    public Mono<jhoel> createJhoel(HhoelDto hhoelDto) {
        return jhoelDaoMongo
                .save(new jhoel().setNombre(hhoelDto.getNombre()));
    }
}
