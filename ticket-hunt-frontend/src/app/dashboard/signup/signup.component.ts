import { Component } from '@angular/core';
import { FormBuilder, ValidationErrors, ValidatorFn, Validators, AbstractControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  //Constructor
  constructor(private fb: FormBuilder) { }
  
  //  Save Method for the data
  saveCustomer(customer: FormGroup) {
    
  }

  customer = this.fb.group({
    name: ['', Validators.required],
    city: ['', Validators.required], 
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
  }, {validator: verifypwd('password', 'cnfPassword')});
  secondFormGroup = this.fb.group({
    secondCtrl: ['', Validators.required],
  });
  isEditable = false;

}
  
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
  