package com.niit.tickethunt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seats {
    private String seatNumber;
    private double price;
    private String dateOfBooking;
}