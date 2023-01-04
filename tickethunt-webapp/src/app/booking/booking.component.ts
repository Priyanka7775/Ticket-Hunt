import { Component, EventEmitter, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { BookingServiceService } from '../service/booking.service';


@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit{

  public rows: Array<String> = [];
  public seats: Array<any> = [];
  public seatAvailable: Array<any> = [];
  /* private refresh!: EventEmitter<void>; */
  booking!: FormGroup;
  price = 0;

 
  
  
  currentDate:any = new Date();

 

  constructor(private bookingsService: BookingServiceService,private fb: FormBuilder
   ){
    this.booking=this.fb.group({
      seatNumber:new FormControl('',[Validators.required]),
      dateOfBooking:new FormControl('',[Validators.required]),
      price : [this.price]
    
    })
  }

  

  ngOnInit() {
   /*  this.refresh = new EventEmitter<void>(); */
    // Hardcoded for now to create seat arrangement for the first time
    this.rows = ['A', 'B', 'C', 'D','E'];
    this.seats = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    this.getSeatsOfEvent('1');
    // used to refresh screen
    this.getData();
   
      this.getSeatsOfEvent('1');

       
    
  }
  
    bookings: any; 
    occupiedSeats: any[] = [];
    selectedSeats: any[]=[];

    bookingData: any;
    seatData: any[] = [];

  

    eventDate: Date = new  Date();
  

  getSeatsOfEvent(eventId: string) {

    this.bookingsService.getParticularBookings(eventId).subscribe(
      (response: any)=> {

        this.bookings = response
        console.log(response)

        this.updateOccupiedSeats();
        this.selectedSeats = [];

       



        /* alert(this.eventDate) */
    })
    
  }



  isSeatSelected(seatNumber: any) {
    return this.selectedSeats.includes(seatNumber);
  }

  updateOccupiedSeats(): void {

    for(const booking of this.bookings.seatList){

     
        this.occupiedSeats.push(booking.seatNumber);
      
    }

  }

  bookSeat() {
    
    const logData = this.booking.value; 
    console.log(logData)
    this.booking.controls['price'].setValue(this.price)

    for(let seat of this.selectedSeats) {
    this.booking.controls['seatNumber'].setValue(seat)
    alert("selected seats are=>"+seat)
    this.bookingsService.bookSeats(this.booking.value).subscribe(
      (response: any) => {
          
          console.log(logData)
          window.location.reload();
            

      }
    )}
  }




  public isSeatReserved(seatNum: string) {
    if (this.occupiedSeats) {
      return this.occupiedSeats.includes(seatNum);
    } 
    return null;
  }

  public checkSeatStatus(seatNum: string): boolean {

    if(this.occupiedSeats.includes(seatNum)){
      return true;
    }
  
    return false;
  }

  public seatSelect(seatNumber: string) {

    if (this.selectedSeats.includes(seatNumber)) {
      // If the seat is already selected, remove it from the array
      this.selectedSeats = this.selectedSeats.filter(s => s !== seatNumber);
      this.booking.controls['seatNumber'].setValue(this.selectedSeats);
// 
    } else {
     
      this.selectedSeats.push(seatNumber);
      console.log(this.selectedSeats)

      if(this.occupiedSeats.includes(seatNumber)){
        localStorage.setItem('seatNumber', seatNumber);
        this.selectedSeats = this.selectedSeats.filter(s => s !== seatNumber);

      }
      else{
      /*  this.selectedSeats.push(seatNumber);  */
        this.booking.controls['seatNumber'].setValue(this.selectedSeats);
      }


    }
  }

  totalprice(){

    if(this.selectedSeats.length == 1){
      this.price = 350
    }
    let totalCost = (this.price * this.selectedSeats.length);
    console.log(totalCost)
  
    return totalCost;

  }
 

  getData(){

    this.bookingsService.bookingHistoryOfUser().subscribe(
      (response: any) => {

       /*  this.bookingData = Object.keys(response).map(key => response[key]);
        
        this.seatData = response.seatList; */

        this.bookingData = response;
        this.eventDate = response.date

        alert(this.seatData)

      }
    )
  }


}