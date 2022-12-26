package com.project.bookingservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "seats")
public class Seats {
    @Id
    private String seatNumber;
    private double price;
}