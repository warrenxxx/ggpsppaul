package org.micap.microlecsson_management.repository;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.micap.common.entity.Function;
import org.micap.common.entity.MicroLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * The MicroLessonDaoImp class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
@Service
public class MicroLessonDaoImp implements MicroLessonDao{

    @Autowired
    public MicroLessonDaoMongo MicroLessonDaoMongo;


    @Autowired
    public ReactiveMongoOperations reactiveMongoOperations;

    public Flux<MicroLesson> getMicroLessons(){
        return  MicroLessonDaoMongo.findAll();
    }

    public Mono<MicroLesson> getMicroLesson(String id){
        return MicroLessonDaoMongo.findById(id);
    }

    public Mono<MicroLesson> CreateMicroLesson(MicroLesson MicroLesson){
        return MicroLessonDaoMongo.save(MicroLesson);
    }

    public Mono<MicroLesson> UpdataMicroLesson(MicroLesson MicroLesson){
        return MicroLessonDaoMongo.save(MicroLesson);
    }
    public Mono<Void> DeleteMicroLesson(MicroLesson MicroLesson){
        return MicroLessonDaoMongo.delete(MicroLesson);
    }
    public Mono<Void> DeleteMicroLessonById(String id){
        return MicroLessonDaoMongo.deleteById(id);
    }

    @Override
    public Mono<Boolean> existById(String id) {
        return MicroLessonDaoMongo.existsById(id);
    }


}

