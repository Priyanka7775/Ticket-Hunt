import { Component } from '@angular/core';
import { User } from 'src/app/model/user.model';
import { SignupService } from 'src/app/service/signup.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent {
  profile: User[] = [];

  constructor(private signupService: SignupService) { }
  // Get user info when loggin

  getUser(email: string) {
    this.signupService.getUser(email).subscribe((x) => (this.profile = x));
  }
}
