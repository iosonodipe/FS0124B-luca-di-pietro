import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Pagina1Component } from './pagina1.component';

const routes: Routes = [{ path: '', component: Pagina1Component }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class Pagina1RoutingModule { }
