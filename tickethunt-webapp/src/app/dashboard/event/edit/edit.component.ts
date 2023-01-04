import { Component, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-edit-event',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditEventComponent {

  constructor(private dataService: DataService,private activatedRoute: ActivatedRoute, private router:Router ) { }
  event:any ={}
  @Input()
  events:any;
  
  ngOnInit(): void {
    // this.dataService.getAllEvents().subscribe(
    //   response=>{
    //     console.log("events")
    //     this.events=response;
    //   }
    // )
    this.activatedRoute.paramMap.subscribe(
      params=>{
        let id = params.get("id") ?? 0;
        this.dataService.getEvent1(+id).subscribe(data => {
              this.event = data;
             })
      }
    )
    
  }
  editNote() {
    this.dataService.editPost(this.event.id,this.event).subscribe(data => {
      this.event = data;
      this.router.navigateByUrl("event/view");
    })
  }

 

}
