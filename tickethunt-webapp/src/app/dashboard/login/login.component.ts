import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/authentication.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private authService: AuthenticationService, private fb: FormBuilder, private router: Router) { }

  user = this.fb.group({
    email: ['', Validators.compose([
      Validators.required,
      Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$'),
    ])],
    password: ['', Validators.required]
  })
  responseData: any;

  login(user: FormGroup) {
    this.authService.login(this.user.value).subscribe({
      next: response => {
        this.responseData = response;
        console.log(response)
        console.log("token : " + this.responseData.token);
        sessionStorage.setItem('jwtkey', this.responseData.token);
        sessionStorage.setItem('userEmail', this.responseData.userEmail);
        sessionStorage.setItem('role', this.responseData.role)
        console.log(this.responseData.role)
        let email = this.responseData.userEmail.split('=')[1].split(',')[0];
        sessionStorage.setItem('emailId', email);
        // alert("Welcome to our app, user!");
        Swal.fire({
          // position: 'top-end',
          icon: 'success',
          title: 'You have succesfully logged in!!',
          showConfirmButton: false,
          timer: 1500
        })

        if (this.responseData.role === "event") {
          this.authService.isRole = "event"
        }
        console.log(this.authService.isRole)
        this.authService.isUserLogedIn == true;
        this.router.navigateByUrl("/home")
      },

      error: err => {
        console.log(err)
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Something went wrong!',

        })
      }

    });
  }
}
