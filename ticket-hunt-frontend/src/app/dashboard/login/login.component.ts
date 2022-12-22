import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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
        
      }
}
