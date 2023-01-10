package com.project.MovieEventService.repository;

import com.project.MovieEventService.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends MongoRepository<Event, String> {
    Event findByEmail(String email);

    //    Event findByEventType(String eventType);
    List<Event> findAllByEventType(String eventType);

    Event findByEventId(String eventId);


}
