package org.micap.jhoela.repository;

import org.micap.jhoela.dto.HhoelDto;
import org.micap.jhoela.entitys.jhoel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The jhoelDao class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :26/03/2018
 */
public interface jhoelDao {
    public Flux<HhoelDto> getJhoels();
    public Mono<HhoelDto> getJhoel(String id);
    public Mono<jhoel> createJhoel(HhoelDto hhoelDto);
}
