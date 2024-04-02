import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Pagina1RoutingModule } from './pagina1-routing.module';
import { Pagina1Component } from './pagina1.component';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  declarations: [
    Pagina1Component
  ],
  imports: [
    CommonModule,
    Pagina1RoutingModule,
    SharedModule
  ]
})
export class Pagina1Module { }
