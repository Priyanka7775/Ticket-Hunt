import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})

export class AddEventComponent {
  constructor(private fb: FormBuilder){}
  addEvent = this.fb.group({
    eventId: [''],
    email: ['', [Validators.required, Validators.minLength(10)]],
    eventName: ['', [Validators.required, Validators.pattern(/^[A-Z].*/)]],
    organizerName: ['', [Validators.required, Validators.minLength(10)]],
    date: ['', [Validators.required, Validators.minLength(10)]],
    time: ['', [Validators.required, Validators.minLength(10)]],
    venue: ['', [Validators.required, Validators.minLength(10)]],
    totalSeat: ['', [Validators.required, Validators.minLength(10)]]
   

  })

  get eventId() { return this.addEvent.get("eventId") }
  get email() { return this.addEvent.get("email") }
  get eventName() { return this.addEvent.get("eventName") }
  get organizerName() { return this.addEvent.get("organizerName") }
  get date() { return this.addEvent.get("date") }
  get time() { return this.addEvent.get("time") }
  get venue() { return this.addEvent.get("venue") }
  get totalSeat() { return this.addEvent.get("totalSeat") }

  onSubmit() {
  }

}
