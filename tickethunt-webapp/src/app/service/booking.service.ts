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

  id = localStorage.getItem('id');

  bookSeat = `http://localhost:8081/bookings/book/1/rohitsnarnaware7@gmail.com`;

  bookingHistory = "http://localhost:8081/bookings/rohitsnarnaware7@gmail.com"

  cancel = "http://localhost:8081/bookings/cancel/1/qqq/"

  getParticularBookings(eventId: any) : Observable<any>{
    return this.http.get<Bookings>(this.url+eventId);
  }

  getAllBookings(): Observable<any> {

    return this.http.get<Bookings>(this.url);
  }

  bookSeats(seat: Seats, id: any) : Observable<any> {

    return this.http.post<Seats>(`http://localhost:8081/bookings/book/${id}/rohitsnarnaware7@gmail.com`, seat);


  }


  bookingHistoryOfUser() : Observable<any> {

    return this.http.get<Bookings>(this.bookingHistory)
  }

  cancelSeats(seat: any, eventId: any) : Observable<any> {

    return this.http.delete<any>(`http://localhost:8081/bookings/cancel/${eventId}/rohitsnarnaware7@gmail.com/${seat}`)

  }

}
