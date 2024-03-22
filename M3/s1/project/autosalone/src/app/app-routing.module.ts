import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FiatComponent } from './pages/fiat/fiat.component';
import { FordComponent } from './pages/ford/ford.component';
import { AudiComponent } from './pages/audi/audi.component';
import { HomeComponent } from './pages/home/home.component';
import { DettaglioComponent } from './pages/dettaglio/dettaglio.component';

const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'fiat',
    component: FiatComponent
  },
  {
    path:'ford',
    component: FordComponent
  },
  {
    path:'audi',
    component: AudiComponent
  },
  {
    path:'cars/:id',
    component: DettaglioComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
