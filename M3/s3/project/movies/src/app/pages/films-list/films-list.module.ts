import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FilmsListRoutingModule } from './films-list-routing.module';
import { FilmsListComponent } from './films-list.component';
import { FilmCardComponent } from './film-card/film-card.component';


@NgModule({
  declarations: [
    FilmsListComponent,
    FilmCardComponent
  ],
  imports: [
    CommonModule,
    FilmsListRoutingModule
  ]
})
export class FilmsListModule { }
