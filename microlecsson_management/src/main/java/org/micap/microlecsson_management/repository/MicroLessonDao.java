package org.micap.microlecsson_management.repository;

import org.micap.common.entity.MicroLesson;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The MicroLessonDao1 class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :20/03/2018
 */
public interface MicroLessonDao {
    public Flux<MicroLesson> getMicroLessons();
    public Mono<MicroLesson> getMicroLesson(String id);
    public Mono<MicroLesson> CreateMicroLesson(MicroLesson MicroLesson);
    public Mono<MicroLesson> UpdataMicroLesson(MicroLesson MicroLesson);
    public Mono<Void> DeleteMicroLesson(MicroLesson MicroLesson);
    public Mono<Void> DeleteMicroLessonById(String id);
    public Mono<Boolean> existById(String id);
}
