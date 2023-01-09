package com.niit.tickethunt.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;


@Node
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id @GeneratedValue
    private Long index;
    private List<Seats> seatList;
    private int totalSeats;
    private String date;
    private String payment;
}
