import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root',
})
export class SignupService {
  constructor(private http: HttpClient) { }

  post(user: User) {
    return this.http.post('http://localhost:8080/userData/commonUser', user);
  }


  getUser(email: string): Observable<Array<User>> {
    return this.http.get<Array<User>>(
      'http://localhost:8080/userData/email/' + email);
  }


  updateUser(email: any, user: any) {
    return this.http.put('http://localhost:8080/userData/update/' + email, user);
  }
}
