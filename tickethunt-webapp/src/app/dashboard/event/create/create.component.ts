import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ThemePalette } from '@angular/material/core';

import { formatDate } from '@angular/common';
import { EventData } from 'src/app/model/event.model';
import { FileHandle } from 'src/app/model/file-handle.model';
import { DomSanitizer } from '@angular/platform-browser';
import { EventService } from 'src/app/service/event.service';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})

export class CreateComponent implements OnInit {

  // Form Data and Validations
  basic = this._formBuilder.group({
    eventId: ['', Validators.required],
    eventName: ['', Validators.required],
    email: ['', Validators.required],
    date: ['', Validators.required],
    time: ['', Validators.required],
    venue: ['', Validators.required],
  });
  secondry = this._formBuilder.group({
    image: ['', Validators.required],
    organizerName: ['', Validators.required],
    seats: ['', Validators.required],
    eventType: ['', Validators.required]
    // price: ['', Validators.required]
  });
  isLinear = false;

  constructor(private _formBuilder: FormBuilder, private sanitizer: DomSanitizer, private eventService: EventService) { }
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
  fileHandler: FileHandle[] = [];
  file1: any;

  // Method to be called when form is submitted
  save(basic: FormGroup, secondry: FormGroup) {
    // Converted this data to event type data
    if (this.fileHandler.length > 0) {
      let eventData: EventData = {
        eventId: basic.get('eventId')?.value,
        email: basic.get('email')?.value,
        eventName: basic.get('eventName')?.value,
        date: formatDate(basic.get('date')?.value, 'dd-MM-yyyy', 'en-US'),
        time: basic.get('time')?.value,
        venue: basic.get('venue')?.value,
        image: this.fileHandler[0],
        organizerName: secondry.get('organizerName')?.value,
        totalSeat: secondry.get('seats')?.value,
        eventType: secondry.get('eventType')?.value,
        // price: secondry.get('price')?.value
      }
      console.log(eventData.eventId)
      // Use this data to save into database
      this.eventService.post(eventData).subscribe(data =>
        console.log(data))

    }

  }

  prepareFormData(data: EventData): FormData {
    const formData = new FormData;

    formData.append('event', new Blob([JSON.stringify(data)], { type: 'application/json' }));
    if (data.image?.file) {
      formData.append('imageFile', data.image?.file, data.image?.file.name)
    }
    return formData;
  }

  onFileSelected(event: any) {
    if (event.target.files) {
      const file = event.target.files[0];
      const fileHandle: FileHandle = {
        file: file,
        url: this.sanitizer.bypassSecurityTrustUrl(
          window.URL.createObjectURL(file)
        )
      }
      this.fileHandler.push(fileHandle);
    }
    // let reader = new FileReader();
    // if (event.target.files && event.target.files.length > 0) {
    //   this.file1 = event.target.files[0];
    // }
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
