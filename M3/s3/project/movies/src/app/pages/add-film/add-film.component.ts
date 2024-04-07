import { Component } from '@angular/core';
import { IFilm } from '../../models/i-film';
import { FilmListService } from '../films-list/film-list.service';

@Component({
  selector: 'app-add-film',
  templateUrl: './add-film.component.html',
  styleUrl: './add-film.component.scss'
})
export class AddFilmComponent {

  constructor(private filmsSvc: FilmListService){}

  film: Partial<IFilm> = {'image': 'https://picsum.photos/200/300'}

  addMovie(){
    this.filmsSvc.addMovie(this.film).subscribe()
  }
}
