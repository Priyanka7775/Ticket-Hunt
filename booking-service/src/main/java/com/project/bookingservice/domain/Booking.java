package com.project.bookingservice.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "bookings")
public class Booking {


    private String email;
    private String eventName;
    @Id
    private String eventId;
    private List<Seats> seatList;
    private int totalSeats;
    private String date;
    private String transactionId;


}
