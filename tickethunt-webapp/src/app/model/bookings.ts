export interface Bookings {
    email: string,
    eventName: string,
    eventId: string,
    venue: string,
    seatList: {
        seatNumber: string,
        price: number,
        dateOfBooking: Date
    },
    totalSeats: number,
    date: Date,
    transactionId: string
    
}


export class Seats {
    public seatNumber: String;
    public  price: number;
     public  dateOfBooking: Date;
     public transactionId: String;
    

    constructor(seatNum: String, price: number,
        dateOfBooking: Date, transactionId: String) {
        this.seatNumber = seatNum;
        this.dateOfBooking = dateOfBooking;
        this.price = price;
        this.transactionId = transactionId;
    }
}