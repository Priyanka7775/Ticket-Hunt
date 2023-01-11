import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventData } from 'src/app/model/event.model';
// import { EVENTS } from 'src/app/model/events';

import { DataService } from 'src/app/service/data.service';


@Component({
  selector: 'app-event-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewEventComponent implements OnInit {

  constructor(private dataService: DataService, private activatedRoute: ActivatedRoute) { }

  eventDetails: any;
  retrieveImage: any;
  base64Data: any;

  @Input()
  events: any;

  event: any = {}

  ngOnInit(): void {
    this.getAllEvents()
  }


  getAllEvents() {
    this.dataService.getEvent1(12).subscribe(response => {
      console.log(response)
      this.eventDetails = response
      //this.base64Data = this.eventDetails.image;
      //console.log(this.base64Data)
      this.retrieveImage = 'data:image/png;base64,' + this.eventDetails.image
      //console.log(this.retrieveImage)

    })
  }

  editNote() {
    this.dataService.editPost(this.event).subscribe(data => {
      this.event = data;
    })
  }

  deleteNote(eventId: any) {
    this.dataService.deletePost(eventId).subscribe(data => {
      console.log("test delete")
      alert("successfully deleted")
      location.reload();
    });

  }



}
