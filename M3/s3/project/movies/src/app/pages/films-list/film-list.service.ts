import { IFilm } from './../../models/i-film';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class FilmListService {

  constructor(private http: HttpClient) {
    this.getAll().subscribe(films => {
      this.filmsSubj.next(films)
    })
  }
  filmsSubj = new BehaviorSubject<IFilm[]>([])
  $films = this.filmsSubj.asObservable()
  apiUrl: string = environment.moviesUrl

  getAll(): Observable<IFilm[]>{
    return this.http.get<IFilm[]>(this.apiUrl)
  }
}
