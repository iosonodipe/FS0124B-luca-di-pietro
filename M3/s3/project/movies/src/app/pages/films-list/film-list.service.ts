import { IFilm } from './../../models/i-film';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';
import { ILogin } from '../../models/i-login';

@Injectable({
  providedIn: 'root',
})
export class FilmListService {
  constructor(private http: HttpClient) {
    this.getAll().subscribe((films) => {
      this.filmsSubj.next(films);
    });
  }
  filmsSubj = new BehaviorSubject<IFilm[]>([]);
  $films = this.filmsSubj.asObservable();
  apiUrl: string = environment.moviesUrl;

  getAll(): Observable<IFilm[]> {
    return this.http.get<IFilm[]>(this.apiUrl);
  }

  deleteMovie(id: number): Observable<IFilm> {
    return this.http.delete<IFilm>(this.apiUrl + '/' + id)
    .pipe(
      tap(() =>
        this.getAll().subscribe((films) => {
          this.filmsSubj.next(films);
        })
      )
    );
  }

  addMovie(film: Partial<IFilm>): Observable<IFilm>{
    return this.http.post<IFilm>(this.apiUrl, film)
    .pipe(
      tap(() =>
        this.getAll().subscribe((films) => {
          this.filmsSubj.next(films);
        })
      )
    );
  }
}
