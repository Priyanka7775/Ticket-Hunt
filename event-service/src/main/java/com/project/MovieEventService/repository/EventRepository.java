package com.project.MovieEventService.repository;

import com.project.MovieEventService.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event,String> {
    Event findByEmail(String email);
<<<<<<< HEAD

    Event findByEventType(String eventType);
=======
   List<Event> findByEventType(String eventType);
>>>>>>> 5050aa6a75fbc2b1172714b1556f379f29a02f49
}
