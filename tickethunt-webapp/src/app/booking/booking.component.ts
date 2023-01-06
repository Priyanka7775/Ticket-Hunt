import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../model/movie.model';
import { BookingServiceService } from '../service/booking.service';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css'],
})
export class BookingComponent implements OnInit {
  public rows: Array<String> = [];
  public seats: Array<any> = [];
  public seatAvailable: Array<any> = [];
  booking!: FormGroup;
  price = 0;

  currentDate: any = new Date();

  id: any;

  constructor(
    private bookingsService: BookingServiceService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private dataService: DataService
  ) {
    this.booking = this.fb.group({
      seatNumber: new FormControl('', [Validators.required]),
      dateOfBooking: new FormControl('', [Validators.required]),
      price: [this.price],
    });
  }

  ngOnInit() {
    this.route.paramMap.subscribe((param) => {
      this.id = param.get('id');
    });
    this.loadData();
    // Hardcoded for now to create seat arrangement for the first time
    this.rows = ['A', 'B', 'C', 'D', 'E'];
    this.seats = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    this.getSeatsOfEvent('1');
    // used to refresh screen
    /* this.getData(); */
  }

  movies: Movie[] = [];

  loadData() {
    let id = parseInt(this.id);
    this.dataService.getMovieById(id).subscribe((data) => (this.movies = data));
  }

  bookings: any;
  occupiedSeats: any[] = [];
  selectedSeats: any[] = [];

  bookingData: any;
  seatData: any[] = [];

  eventDate: Date = new Date();

  getSeatsOfEvent(eventId: string) {
    this.bookingsService
      .getParticularBookings(eventId)
      .subscribe((response: any) => {
        this.bookings = response;
        console.log(response);
        this.updateOccupiedSeats();
        this.selectedSeats = [];
        /* alert(this.eventDate) */
      });
  }

  isSeatSelected(seatNumber: any) {
    return this.selectedSeats.includes(seatNumber);
  }

  updateOccupiedSeats(): void {
    for (const booking of this.bookings.seatList) {
      this.occupiedSeats.push(booking.seatNumber);
    }
  }

  bookSeat() {
    const logData = this.booking.value;
    console.log(logData);
    this.booking.controls['price'].setValue(this.price);

    for (let seat of this.selectedSeats) {
      this.booking.controls['seatNumber'].setValue(seat);
      alert('selected seats are=>' + seat);
      this.bookingsService
        .bookSeats(this.booking.value)
        .subscribe((response: any) => {
          console.log(logData);
          window.location.reload();
        });
    }
  }

  public isSeatReserved(seatNum: string) {
    if (this.occupiedSeats) {
      return this.occupiedSeats.includes(seatNum);
    }
    return null;
  }

  public checkSeatStatus(seatNum: string): boolean {
    if (this.occupiedSeats.includes(seatNum)) {
      return true;
    }
    return false;
  }

  getSeatColor(seatNumber: string) {
    if (this.occupiedSeats.includes(seatNumber)) {

      return 'rgba(212, 43, 43, 0.767)';

    }
    if (!this.selectedSeats.includes(seatNumber)) {

      return 'whitesmoke';
    }
    
    else {
      return "rgba(74, 158, 74, 0.582)";
    }
  }


  public seatSelect(seatNumber: string) {
    if (this.selectedSeats.includes(seatNumber)) {
      // If the seat is already selected, remove it from the array
      this.selectedSeats = this.selectedSeats.filter((s) => s !== seatNumber);
      this.booking.controls['seatNumber'].setValue(this.selectedSeats);
      //
    } else {
      this.selectedSeats.push(seatNumber);
      console.log(this.selectedSeats);

      if (this.occupiedSeats.includes(seatNumber)) {
        localStorage.setItem('seatNumber', seatNumber);
        this.selectedSeats = this.selectedSeats.filter((s) => s !== seatNumber);
      } else {
        /*  this.selectedSeats.push(seatNumber);  */
        this.booking.controls['seatNumber'].setValue(this.selectedSeats);
      }
    }
  }

  totalprice() {
    if (this.selectedSeats.length == 1) {
      this.price = 350;
    }
    let totalCost = this.price * this.selectedSeats.length;
    console.log(totalCost);

    return totalCost;
  }

  getData(){

    this.bookingsService.bookingHistoryOfUser().subscribe(
      (response: any) => {

        this.bookingData = response;
        this.eventDate = response.date

      }
    )

  /* getData() {
    this.bookingsService.bookingHistoryOfUser().subscribe((response: any) => {
    

      this.bookingData = response;
      this.eventDate = response.date;
    });
  }
  } */
}
}
