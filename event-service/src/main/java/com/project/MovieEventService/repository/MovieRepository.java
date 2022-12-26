package com.project.MovieEventService.repository;

import com.project.MovieEventService.domain.Event;
import com.project.MovieEventService.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie,String> {

}
