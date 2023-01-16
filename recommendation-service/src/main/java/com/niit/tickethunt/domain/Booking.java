package com.niit.tickethunt.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;


@Node
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    private int totalSeats;
    private String date;
    private String email;
    private String payment;
    @Relationship(type = "BOOKING", direction = Relationship.Direction.INCOMING)
    private List<Seats> seatList;

}
