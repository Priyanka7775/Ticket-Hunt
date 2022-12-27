package com.project.MovieEventService.repository;

import com.project.MovieEventService.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event,String> {
    Event findByEmail(String email);
   List<Event> findByEventType(String eventType);
}
