import { ThisReceiver } from '@angular/compiler';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/model/movie.model';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private dataService: DataService,private route: Router) { }
  @Input()
  events1:any;
  events2:any;

  movies: Movie[] = [];
  event:any ={}
  image:string =''
 
  ngOnInit(): void {
    this.viewEvent();
    this.viewMovie();
    
  }

  viewMovie(){
    this.dataService.getAllEvents3().subscribe(
      response=>{
        console.log("movie")
        this.events1=response;
        
      }
      
    )
  
    
  }

  viewEvent(){
    this.dataService.getAllEvents2().subscribe(
      response=>{
        console.log("events")
        this.events2=response;
      }
    )
  
    
  }
  navigateToMovieDetail(eventId:any){
    this.route.navigate(["detail",eventId])
  }
  


}
