import { Component } from '@angular/core';
import { FormBuilder, ValidationErrors, ValidatorFn, Validators, AbstractControl, FormGroup} from '@angular/forms';
import { User } from 'src/app/model/user.model';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  //Constructor
  constructor(private fb: FormBuilder) { }
  
  // Basic Information 
  customer = this.fb.group({
    name: ['', Validators.required],
    city: ['', Validators.required], 
     phone: ['',
      Validators.compose([
        Validators.required,
        Validators.pattern('(9|8|7)[0-9]{9}'),
      ])],
      email: ['', Validators.compose([
            Validators.required,
            Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$'),
          ])],
      password: ['', Validators.compose([
            Validators.required,
            Validators.pattern(
              '^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d\\W]{8,63}$'
            ),
          ])],
      cnfPassword:['', Validators.required]
  }, { validator: verifypwd('password', 'cnfPassword') });

  // Second form Data 
  interest = this.fb.group({
     action: false,
     drama: false,
     horror: false,
     science: false,
     role: ['', Validators.required],
  });

  isEditable = false;

  // Once form is subbmited below method is called
  saveUser(customer: FormGroup, interest: FormGroup) {
    // Converting interest data to String Array
    let interested: String[] = [];

    //Checking for user interest in the selection

    if (interest.get('action')?.value) {
      interested.push('action')
    }
    if (interest.get('drama')?.value) {
      interested.push('drama')
    }
    if (interest.get('horror')?.value) {
      interested.push('horror')
    }
    if (interest.get('science')?.value) {
      interested.push('science')
    }

      // Saving all data to user
      const userData: User = {
       name: customer.get('name')?.value, 
       email: customer.get('email')?.value,
        password: customer.get('password')?.value, 
        city: customer.get('city')?.value,
        phone: customer.get('phone')?.value,
        interest: interested,
       role: interest.get('role')?.value
    }
    // Logging data for testing - Use userData to submit data 
    console.log(userData);
  }
}

// Out function to check password and confirm password is same or different 

export function verifypwd(pass: string, cnfPass: string): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const password = control.get(pass)?.value;
    const cnfPassword = control.get(cnfPass)?.value;
    if (password != cnfPassword) {
      const err = { 'noMatch': true };
      control.get(cnfPass)?.setErrors(err);
      return err;
    } 
    return null;
  }
}
  