import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './dashboard/home/home.component';
import { LoginComponent } from './dashboard/login/login.component';
import { NotFoundComponent } from './dashboard/not-found/not-found.component';
import { SignupComponent } from './dashboard/signup/signup.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home', 
    pathMatch: 'full'
  },
  {
    path: '/home',
    component: HomeComponent, 
  },
  {
    path: '/login', 
    component: LoginComponent
  },
  {
    path: '/signup', 
    component: SignupComponent
  },
  {
    path: '/404',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
