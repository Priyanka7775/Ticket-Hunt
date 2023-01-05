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
@AllArgsConstructor
@NoArgsConstructor
public class User {
   @Id @GeneratedValue
   private Long id;
   private String name;
   private String email;
   private String city;
   private String role;
   private List<String> interest;
   private long phone;

   @Relationship(type = "BOOKED", direction = Relationship.Direction.OUTGOING)
   private Booking booking;
}
