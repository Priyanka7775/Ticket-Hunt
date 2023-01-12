import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/authentication.service';
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
        this.authService.login(this.user.value).subscribe(
          response=>{
            console.log(response);
            this.responseData=response;
            console.log("token : "+this.responseData.token);
            sessionStorage.setItem('jwtkey',this.responseData.token);
            sessionStorage.setItem('userEmail',this.responseData.userEmail);
            alert("Welcome user!"+this.responseData.userEmail);
            if(this.authService.isUserLogedIn==true){
              this.router.navigateByUrl("/home")
            }
            else{
              alert("Wrong Data");
            }
          }
        );
      }
}
