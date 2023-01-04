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
    

    constructor(seatNum: String, isSelected: boolean, price: number,
        dateOfBooking: Date) {
        this.seatNumber = seatNum;
        this.dateOfBooking = dateOfBooking;
        this.price = price;
    }
}