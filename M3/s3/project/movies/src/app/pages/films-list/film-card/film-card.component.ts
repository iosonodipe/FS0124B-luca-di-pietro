import { Component, Input } from '@angular/core';
import { IFilm } from '../../../models/i-film';

@Component({
  selector: 'app-film-card',
  templateUrl: './film-card.component.html',
  styleUrl: './film-card.component.scss'
})
export class FilmCardComponent {
  @Input() film!: IFilm
}
