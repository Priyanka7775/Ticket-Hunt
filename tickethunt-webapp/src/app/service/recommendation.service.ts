import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, retry } from 'rxjs';
import { RecEvent } from '../model/recEvent.model';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root',
})
export class RecommendationService {
  constructor(private http: HttpClient) {}

  getAllEvents(): Observable<Array<RecEvent>> {
    return this.http.get<Array<RecEvent>>(
      'https://localhost:8086/api/v4/events'
    );
  }

  getAllUsers(): Observable<Array<User>> {
    return this.http.get<Array<User>>('https://localhost:8086/api/v4/users');
  }

  addBooking(user: number[]) {
    return this.http.post('https://localhost:8086/api/v4/users', user);
  }
}