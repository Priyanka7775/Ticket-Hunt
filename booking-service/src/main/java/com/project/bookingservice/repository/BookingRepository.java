package com.project.bookingservice.repository;

import com.project.bookingservice.domain.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {

    Booking findByEventId(String evenId);

    Booking findByEmail(String email);

//   Booking findBySeatListSeatNumber(String evenId, String seatNumber);

    Booking findByEventIdAndSeatListSeatNumber(String evenId, String seatNumber);

    Booking findByEventIdAndEmail(String eventId, String email);


}