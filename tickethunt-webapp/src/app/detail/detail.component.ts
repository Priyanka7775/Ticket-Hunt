import { Component, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent {
  constructor(private activatedRoute: ActivatedRoute, private dataService:DataService, private router:Router) { }
  event:any ={}
 
  @Input()
  events:any;

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
     
      params=>{
        let id = params.get("id");
        console.log(id);
        this.dataService.getEvent1(id).subscribe(data => {
              console.log(data);
              this.event = data;
             /*  localStorage.setItem("eventName", this.event.eventName);
              localStorage.setItem("date", this.event.date);
              localStorage.setItem("venue", this.event.venue); */

              localStorage.setItem("price", this.event.price)
              console.log(data);
             })
      }
    )
    
  }
  book() {
    this.router.navigate(['booking/' + this.event.eventId]);
  }
  
}
