import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ThemePalette } from '@angular/material/core';
import { EventData } from 'src/app/model/event.model';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
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
  ngOnInit(): void {

  }
  
  slideToggler() {
    const slideO = document.getElementById('img-one');
    if (slideO?.classList.contains('slide-active')) {
      slideO?.classList.remove('slide-active')
      slideO?.classList.add('slide-inactive')
    } else {
      slideO?.classList.remove('slide-inactive')
      slideO?.classList.add('slide-active')
    }
  }

  // Default placeholder date 

  defaultDate = new Date();

  // Method to be called when form is submitted
  save(basic: FormGroup, secondry: FormGroup) {

    // Converted this data to event type data

    let eventData: EventData = {
      name: basic.get('name')?.value,
      date: basic.get('date')?.value,
      time: basic.get('time')?.value,
      venue: basic.get('venue')?.value,
      image: secondry.get('image')?.value,
      organizer: secondry.get('organizer')?.value,
      seats: secondry.get('seats')?.value
    }

    // Use this data to save into database
    console.log(eventData);
    
  }

  /** Override the ante meridiem abbreviation. */
  @Input() anteMeridiemAbbreviation = 'am';

  /** Override the post meridiem abbreviation. */
  @Input() postMeridiemAbbreviation = 'pm';

  /* Sets the clock mode, 12-hour or 24-hour clocks are supported. */
  @Input() mode: '12h' | '24h' = '24h';

  /* Set the color of the timepicker control */
  @Input() color: ThemePalette = 'primary';
}
