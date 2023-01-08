import { Component, OnInit } from '@angular/core';
import { Bookings } from '../model/bookings';
import { BookingServiceService } from '../service/booking.service';

@Component({
  selector: 'app-booking-history',
  templateUrl: './booking-history.component.html',
  styleUrls: ['./booking-history.component.css']
})
export class BookingHistoryComponent implements OnInit{

  constructor(private bookingsService: BookingServiceService) {
    
  }

  ngOnInit() {
this.getData();

  }

  bookingData: any;

getData(){

  this.bookingsService.bookingHistoryOfUser().subscribe(
    (response:any) => {

      
      this.bookingData = response;
      console.log(response);
      
    

    }
  )
}




delete(seat: any) {

  
  alert("successfully canceled seat =>"+seat)
  window.location.reload();
  this.bookingsService.cancelSeats(seat).subscribe(
    (response:any) => {

    }

)}


}