package org.micap.microlecsson_management.repository;

import org.micap.common.entity.MicroLesson;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * The MicroLessonDaoMongo class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
public interface MicroLessonDaoMongo extends ReactiveMongoRepository<MicroLesson,String> {
}
