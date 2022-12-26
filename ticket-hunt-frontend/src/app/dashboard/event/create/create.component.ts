import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ThemePalette } from '@angular/material/core';
import { EventData } from 'src/app/model/event.model';
import { formatDate } from '@angular/common';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})

export class CreateComponent implements OnInit {

 // Form Data and Validations
  basic = this._formBuilder.group({
    name: ['', Validators.required],
    date: ['', Validators.required],
    time: ['', Validators.required],
    venue: ['', Validators.required],
    });
    secondry = this._formBuilder.group({
      image: ['', Validators.required],
      organizer: ['', Validators.required],
      seats: ['', Validators.required]
    });
    isLinear = false;

  constructor(private _formBuilder: FormBuilder) { }
  ngOnInit(): void {

  }
  
  // Toggler 
  // slideToggler() {
  //   const slideO = document.getElementById('img-one');
  //   if (slideO?.classList.contains('slide-active')) {
  //     slideO?.classList.remove('slide-active')
  //     slideO?.classList.add('slide-inactive')
  //   } else {
  //     slideO?.classList.remove('slide-inactive')
  //     slideO?.classList.add('slide-active')
  //   }
  // }

  // Default placeholder date

  // Current Date Placeholder
  defaultDate = new Date();

  // Method to be called when form is submitted
  save(basic: FormGroup, secondry: FormGroup) {


    // Converted this data to event type data
    let eventData: EventData = {
      name: basic.get('name')?.value,
      date: formatDate(basic.get('date')?.value, 'dd-MM-yyyy', 'en-US'),
      time: basic.get('time')?.value,
      venue: basic.get('venue')?.value,
      image: secondry.get('image')?.value,
      organizer: secondry.get('organizer')?.value,
      seats: secondry.get('seats')?.value
    }

    // Use this data to save into database
    console.log(eventData);
    
  }

  // Property for mat-ti
  /** Override the ante meridiem abbreviation. */
  @Input() anteMeridiemAbbreviation = 'am';

  /** Override the post meridiem abbreviation. */
  @Input() postMeridiemAbbreviation = 'pm';

  /* Sets the clock mode, 12-hour or 24-hour clocks are supported. */
  @Input() mode: '12h' | '24h' = '24h';

  /* Set the color of the timepicker control */
  @Input() color: ThemePalette = 'primary';
}
