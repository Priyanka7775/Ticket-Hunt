package com.niit.tickethunt.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface BookingRepository extends Neo4jRepository<Booking, Long> {
    @Query("MATCH (user:User), (booking:Booking) WHERE ID(user) = $user AND ID(booking) = $booking CREATE (user) - [:BOOKING] -> (booking)")
    void addBooking(int booking, int user);

    @Query("MATCH (booking:Booking) WHERE booking.email = $email RETURN booking")
    Booking findByEmail(String email);
}
