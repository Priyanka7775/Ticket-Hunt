package com.niit.tickethunt.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    private Long id;
    private List<Seats> seatList;
    private int totalSeats;
    private String date;
    private String payment;
}
