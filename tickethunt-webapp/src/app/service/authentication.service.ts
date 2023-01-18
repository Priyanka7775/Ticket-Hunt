import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor(private httpClient: HttpClient) {}

  url="http://localhost:8084/niit/auth";
  isUserRegistered:boolean=false;
  isUserLogedIn:boolean=false;
 

  register(userData: any) {
    this.isUserRegistered = true;
    return this.httpClient.post(this.url + '/register', userData);
  }

  login(userData: any) {
    this.isUserLogedIn = true;
    return this.httpClient.post(this.url + '/login', userData);
  }
}
