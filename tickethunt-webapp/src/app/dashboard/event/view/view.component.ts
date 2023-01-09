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
  
  constructor(private dataService: DataService,private activatedRoute: ActivatedRoute ) { }

  @Input()
  events:any;

  event:any ={}
  
  ngOnInit(): void {
    this.dataService.getAllEvents().subscribe(
      response=>{
        console.log("events")
        this.events=response;
      }
    )
    
  }
  editNote() {
    this.dataService.editPost(this.event).subscribe(data => {
      this.event = data;
    })
  }

  deleteNote(eventId:any){
    this.dataService.deletePost(eventId).subscribe(data =>{
      console.log("test delete")
      alert("successfully deleted")
      location.reload();
    });
    
  }


 
}
