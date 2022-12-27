package com.project.MovieEventService.repository;

import com.project.MovieEventService.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event,String> {
    Event findByEmail(String email);

    Event findByEventType(String eventType);
}
