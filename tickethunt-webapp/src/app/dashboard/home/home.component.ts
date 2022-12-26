import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/model/movie.model';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private dataService: DataService) { }

  movies: Movie[] = [];

  ngOnInit(): void {
    this.getAll();
  }
  
  getAll(){
    this.dataService.getAllMovies().subscribe(movie => {
      this.movies = movie;
    })
  }

}
