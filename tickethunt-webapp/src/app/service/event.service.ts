import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private http: HttpClient) { }

  post(eventData: FormData) {
    return this.http.post('http://localhost:8088/eventdata/push', eventData);
  }
}
