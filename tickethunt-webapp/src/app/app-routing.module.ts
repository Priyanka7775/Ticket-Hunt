import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './dashboard/event/create/create.component';
import { EditEventComponent } from './dashboard/event/edit/edit.component';
import { EventComponent } from './dashboard/event/event.component';
import { ViewEventComponent } from './dashboard/event/view/view.component';
import { HomeComponent } from './dashboard/home/home.component';
import { LoginComponent } from './dashboard/login/login.component';
import { NotFoundComponent } from './dashboard/not-found/not-found.component';
import { SignupComponent } from './dashboard/signup/signup.component';
import { TileComponent } from './dashboard/tile/tile.component';
import { UserComponent } from './dashboard/user/user.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home', 
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent, 
  },
  {
    path: 'login', 
    component: LoginComponent
  },
  {
    path: 'signup', 
    component: SignupComponent
  },
  {
    path: 'tile/:id',
    component: TileComponent,
  },
  {
    path: 'user',
    component: UserComponent
  },
  {
    path: 'event', 
    component: EventComponent
  },
  {
    path: 'event/create', 
    component: CreateComponent
  },
  {
    path: 'event/view',
    component: ViewEventComponent
  },
  {
    path: 'event/edit/:id',
    component: EditEventComponent
  }
  ,
  {
    path: '404',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
