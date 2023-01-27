import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user.model';
import { SignupService } from 'src/app/service/signup.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  profile: any = [];

  constructor(private signupService: SignupService, private router:Router) { }
  ngOnInit(): void {
    let email = sessionStorage.getItem('emailId');
    if(email){
      this.getUser(email);
    }
  }


  // Get user info when loggin

  getUser(email: string) {
    if (email != '') {
      this.signupService.getUser(email).subscribe((x) => {
        this.profile = x;
      }, (error) => {
        this.profile.push(error.error);
      });
    } else {
      this.router.navigate(['/login']);
    }
  }
}
