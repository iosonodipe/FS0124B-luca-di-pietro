import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FilmsListRoutingModule } from './films-list-routing.module';
import { FilmsListComponent } from './films-list.component';


@NgModule({
  declarations: [
    FilmsListComponent
  ],
  imports: [
    CommonModule,
    FilmsListRoutingModule
  ]
})
export class FilmsListModule { }
