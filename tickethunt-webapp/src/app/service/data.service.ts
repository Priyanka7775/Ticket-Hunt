import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../model/movie.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getAllMovies() {
    return this.http.get<Array<Movie>>('http://localhost:3000/movies');
  }
  getMovieById(id: number) {
    return this.http.get<Array<Movie>>('http://localhost:3000/movies/?id=' + id);
  }
  getAllEvents(){
    return this.http.get<Array<Event>>('http://localhost:3000/events')
  }
  editPost(id?: string,event?: any) {
    return this.http.put<Event>("http://localhost:3000/events/"+id,event);
  }
  getEvent1(id?: number) : Observable<Event> {
    return this.http.get<Event>(`${"http://localhost:3000/events"}/${id}`);
  }
  

  deletePost(id?: string){
    console.log("test deletepost")
    return this.http.delete("http://localhost:3000/events/"+id)
  }
}
