import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/service/authentication.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  constructor(private fb: FormBuilder) { }
  
    user = this.fb.group({
        email: ['', Validators.compose([
              Validators.required,
              Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$'),
            ])],
        password: ['', Validators.required]
        
      })

      login(user: FormGroup) {
        this.authService.login(this.loginForm.value).subscribe(
          response=>{
            console.log(response);
            this.responseData=response;
            console.log("token : "+this.responseData.token);
            localStorage.setItem('jwtkey',this.responseData.token);
            localStorage.setItem('userEmail',this.responseData.userEmail);
            alert("Welcome user!"+this.responseData.userEmail);
            if(this.authService.isUserLogedIn==true){
              this.router.navigateByUrl("/songs")
            }
            else{
              alert("Wrong Data");
            }
          }
        );

      }
}
