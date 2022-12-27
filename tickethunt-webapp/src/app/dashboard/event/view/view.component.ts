import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventData } from 'src/app/model/event.model';
import { EVENTS } from 'src/app/model/events';

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
    // this.activatedRoute.paramMap.subscribe(params => {
    //   let id = params.get("id") ?? 0;
    //   this.dataService.getEvent1(+id).subscribe(data => {
    //     this.event = data;
    //   })
    // });
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

  deleteNote(id:any){
    this.dataService.deletePost(id).subscribe(data =>{
      console.log("test delete")
      location.reload();
    });
    
  }


 
}
