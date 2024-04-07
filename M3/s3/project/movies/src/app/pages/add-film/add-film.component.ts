import { Component } from '@angular/core';
import { IFilm } from '../../models/i-film';
import { FilmListService } from '../films-list/film-list.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-film',
  templateUrl: './add-film.component.html',
  styleUrl: './add-film.component.scss'
})
export class AddFilmComponent {

  constructor(private filmsSvc: FilmListService, private router: Router){}

  film: Partial<IFilm> = {'image': 'https://picsum.photos/200/300'}
  isAdded: boolean = false

  addMovie(){
    this.filmsSvc.addMovie(this.film).subscribe(() =>{
      this.isAdded = true

      setTimeout(()=> {
        this.router.navigate(['films-list'])
        this.isAdded = false
      }, 2000)
    })
  }
}
