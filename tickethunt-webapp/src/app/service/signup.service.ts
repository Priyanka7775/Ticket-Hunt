import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http:HttpClient) {}
  post(user:User){return this.http.post('http://localhost:8080/userdata/adduser',user)}
}
