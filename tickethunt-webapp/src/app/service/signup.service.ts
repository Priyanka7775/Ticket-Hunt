import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root',
})
export class SignupService {
  constructor(private http: HttpClient) {}
  post(user: User) {
    return this.http.post('http://localhost:8080/userData/commonUser', user);
  }
  getUser(email: string): Observable<Array<User>> {
    return this.http.get<Array<User>>(
      'http://localhost:8080/userData/email/' + email
    );
  }
  updateUser(user:any) {
    return this.http.post('http://localhost:8082/userData/email{email}', user);
  }
}
