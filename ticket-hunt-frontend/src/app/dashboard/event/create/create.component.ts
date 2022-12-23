import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent {
  basic = this._formBuilder.group({
    name: ['', Validators.required],
    date: [''],
    time: [''],
    venue: [''],
    });
    secondry = this._formBuilder.group({
      image: [''],
      organizer: [''],
      seats: ['']
    });
    isLinear = false;

  constructor(private _formBuilder: FormBuilder) { }
  

  // Method to be called when form is submitted
  save() {
    alert('saved');
  }
}
