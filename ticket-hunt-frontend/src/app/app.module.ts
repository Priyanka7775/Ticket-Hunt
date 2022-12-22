import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './dashboard/login/login.component';
import { SignupComponent } from './dashboard/signup/signup.component';
import { HomeComponent } from './dashboard/home/home.component';
import { NotFoundComponent } from './dashboard/not-found/not-found.component';
import { HeaderComponent } from './header/header.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { TileComponent } from './dashboard/tile/tile.component';
import { HttpClientModule } from '@angular/common/http';

// Material Imports
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatStepperModule } from '@angular/material/stepper';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatRadioModule } from '@angular/material/radio';
import { MatChipsModule } from '@angular/material/chips';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    NotFoundComponent,
    HeaderComponent,
    DashboardComponent,
    TileComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    FormsModule, 
    ReactiveFormsModule,
    MatInputModule,
    MatStepperModule,
    MatCheckboxModule,
    MatRadioModule,
    MatChipsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
