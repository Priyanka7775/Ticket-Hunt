import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bookings, Seats } from '../model/bookings';


@Injectable({
  providedIn: 'root'
})
export class BookingServiceService {

  constructor(private http:HttpClient) { }

  url = "http://localhost:8081/bookings/view/";

  bookSeat = "http://localhost:8081/bookings/book/1/rohit@gmail.com";

  bookingHistory = "http://localhost:8081/bookings/rohit@gmail.com"

  cancel = "http://localhost:8081/bookings/cancel/1/rohit@gmail.com/"

  getParticularBookings(eventId: any) : Observable<any>{
    return this.http.get<Bookings>(this.url+eventId);
  }

  getAllBookings(): Observable<any> {

    return this.http.get<Bookings>(this.url);
  }

  bookSeats(seat: any) : Observable<any> {

    return this.http.post<Seats>(this.bookSeat, seat);


  }


  bookingHistoryOfUser() : Observable<any> {

    return this.http.get<Bookings>(this.bookingHistory)
  }

  cancelSeats(seat: any) : Observable<any> {

    return this.http.delete<any>(this.cancel+seat)

  }

}
