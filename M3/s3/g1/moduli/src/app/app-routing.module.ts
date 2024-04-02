import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './pages/auth/auth.guard';

const routes: Routes = [
  {
    path: '',
    loadChildren: () =>
      import('./pages/home/home.module').then((m) => m.HomeModule),
  },
  {
    path: 'pagina1',
    loadChildren: () =>
      import('./pages/pagina1/pagina1.module').then((m) => m.Pagina1Module),
  },
  {
    path: 'pagina2',
    loadChildren: () =>
      import('./pages/pagina2/pagina2.module').then((m) => m.Pagina2Module),
      canActivate: [AuthGuard],
      canActivateChild: [AuthGuard]
  },
  { path: 'auth', loadChildren: () => import('./pages/auth/auth.module').then(m => m.AuthModule) },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
