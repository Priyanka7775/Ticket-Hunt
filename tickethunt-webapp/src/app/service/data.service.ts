import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../model/movie.model';
import { Observable } from 'rxjs';
import { EventData } from '../model/event';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  constructor(private http: HttpClient) {}

  getAllMovies() {
    return this.http.get<Array<Movie>>('http://localhost:8080/movies');
  }

  getMovieById(id: number) {
    return this.http.get<Array<Movie>>(
      'http://localhost:8080/movies/?id=' + id
    );
  }

  getAllEvents() {
    return this.http.get<Array<Event>>('http://localhost:8080/eventData/event');
  }
  getAllEvent() {
    return this.http.get<Array<EventData>>(
      'http://localhost:8080/eventData/event'
    );
  }

  editPost(id?: string, event?: any) {
    return this.http.put<Event>(
      'http://localhost:8080/eventData/updateEvent/' + id,
      event
    );
  }

  getEvent1(id?: any): Observable<Event> {
    return this.http.get<Event>(
      `${'http://localhost:8080/eventData/getEvent1'}/${id}`
    );
  }

  deletePost(id?: string) {
    console.log('test deletepost');
    return this.http.delete('http://localhost:8080/eventData/delete/' + id);
  }

  getEventByEmail(emailId: string) {
    return this.http.get('http://localhost:8080/eventData/event/' + emailId);
  }

  getAllEvents3() {
    return this.http.get<Array<Event>>(
      'http://localhost:8080/eventData/getEvent/movie'
    );
  }
  getAllEvents2() {
    return this.http.get<Array<Event>>(
      'http://localhost:8080/eventData/getEvent/event'
    );
  }
}
