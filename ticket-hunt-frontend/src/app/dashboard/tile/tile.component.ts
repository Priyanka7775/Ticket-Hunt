import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Movie } from 'src/app/model/movie.model';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-tile',
  templateUrl: './tile.component.html',
  styleUrls: ['./tile.component.css']
})
export class TileComponent implements OnInit {
  
  constructor(private route: ActivatedRoute, private dataService:DataService) { }
  
  ngOnInit(): void {
    this.route.paramMap.subscribe(param => {
      this.id = param.get('id');
    })
    this.getMovie();
  }
  id: any;

  movies: Movie[]  = [];

  getMovie() {
    let id = parseInt(this.id);
    this.dataService.getMovieById(id).subscribe(value => this.movies = value);
  }
  
}
