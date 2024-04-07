import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddFilmRoutingModule } from './add-film-routing.module';
import { AddFilmComponent } from './add-film.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AddFilmComponent
  ],
  imports: [
    CommonModule,
    AddFilmRoutingModule,
    FormsModule
  ]
})
export class AddFilmModule { }
