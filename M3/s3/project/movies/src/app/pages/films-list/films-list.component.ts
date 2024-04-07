import { Component } from '@angular/core';
import { IFilm } from '../../models/i-film';
import { FilmListService } from './film-list.service';

@Component({
  selector: 'app-films-list',
  templateUrl: './films-list.component.html',
  styleUrl: './films-list.component.scss'
})
export class FilmsListComponent {

  constructor(private filmsSvc: FilmListService){
    filmsSvc.$films.subscribe(films => this.filmsArray = films)
  }

  filmsArray: IFilm[] = []

}
