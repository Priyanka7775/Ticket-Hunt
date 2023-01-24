import { ThisReceiver } from '@angular/compiler';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventData } from 'src/app/model/event';
import { Movie } from 'src/app/model/movie.model';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
<<<<<<< HEAD
  constructor(private dataService: DataService, private route: Router, private authService: AuthenticationService) {}
=======
  constructor(private dataService: DataService, private route: Router) { }
>>>>>>> fb544483fedd8a32dbf056cb3e4048f7e3f75e9c
  @Input()
  events1: any;
  events2: any;

  movies: EventData[] = [];
  carry: EventData[] = [];
  event: any = {};
  image: string = '';
  i: number = 1;
  isLoggedIn: boolean = false;
  ngOnInit(): void {
    this.viewEvent();
    this.viewMovie();
    // this.changeSlider();
    this.verifyUser();
  }

  viewMovie() {
    this.dataService.getAllEvents3().subscribe((response) => {
      this.events1 = response;
    });
    this.dataService.getAllEvent().subscribe((value) => {
      value.forEach((element) => {
        this.movies.push(element);
      });
      this.carry.push(this.movies[0]);
    });
  }

  viewEvent() {
    this.dataService.getAllEvents2().subscribe((response) => {
      console.log('events');
      this.events2 = response;
    });
  }
  navigateToMovieDetail(eventId: any) {
    this.route.navigate(['detail', eventId]);
  }
  verifyUser(){
    setInterval(() => {
      this.isLoggedIn = this.authService.isUserLogedIn;
    }, 1000)
  }
  changeSlider() {
    setInterval(() => {
      let id = this.movies[this.i]?.eventId;
      let card = document.getElementById(id + '-card');
      let pop = document.getElementById('event-pop');
      if (this.i < this.movies.length) {
        this.carry.pop();
        // pop?.classList.add('pop');
        this.carry.push(this.movies[this.i]);
        this.i++;
        // setInterval(() => {
        //   pop?.classList.remove('pop');
        // }, 3000);
      } else {
        this.i = 0;
        this.carry.pop();
        this.carry.push(this.movies[0]);
      }
    }, 7000);
  }
}
