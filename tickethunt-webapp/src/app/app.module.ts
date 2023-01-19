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
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TileComponent } from './dashboard/tile/tile.component';
import { HttpClientModule } from '@angular/common/http';
import { UserComponent } from './dashboard/user/user.component';


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
import { EventComponent } from './dashboard/event/event.component';
import { CreateComponent } from './dashboard/event/create/create.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatTableModule } from '@angular/material/table';

import { NgxMatTimepickerModule } from 'ngx-mat-timepicker';
import { EditEventComponent } from './dashboard/event/edit/edit.component';
import { ViewEventComponent } from './dashboard/event/view/view.component';
import { BookingComponent } from './booking/booking.component';
import { BookingHistoryComponent } from './booking-history/booking-history.component';
import { PaymentComponent } from './payment/payment.component';
import { ConfirmationComponent } from './confirmation/confirmation.component';
import { NgxPaginationModule} from 'ngx-pagination';
import { DetailComponent } from './detail/detail.component';
import { NextDirective } from './next.directive';
import { PrevDirective } from './prev.directive';
import { NgxSpinnerModule } from 'ngx-spinner';
<<<<<<< HEAD
import { EventManagerComponent } from './event-manager/event-manager.component';
=======
import { HomePageComponent } from './home-page/home-page.component';
>>>>>>> 93a03e45d29075b55868154744291d4d3cde3184

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
    UserComponent,
    EventComponent,
    CreateComponent,
    EditEventComponent,
    ViewEventComponent,
    BookingComponent,
    BookingHistoryComponent,
    PaymentComponent,
    ConfirmationComponent,
    DetailComponent,
    NextDirective,
    PrevDirective,
<<<<<<< HEAD
    EventManagerComponent,
=======
    HomePageComponent,
>>>>>>> 93a03e45d29075b55868154744291d4d3cde3184
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
    HttpClientModule,
    MatDatepickerModule,
    MatNativeDateModule,
    NgxMatTimepickerModule,
    MatTableModule,
    NgxPaginationModule,
    NgxSpinnerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
