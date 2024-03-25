import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InactivePostsComponent } from './pages/inactive-posts/inactive-posts.component';
import { ActivePostsComponent } from './pages/active-posts/active-posts.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'active-posts',
    component:  ActivePostsComponent
  },
  {
    path:'inactive-posts',
    component: InactivePostsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
