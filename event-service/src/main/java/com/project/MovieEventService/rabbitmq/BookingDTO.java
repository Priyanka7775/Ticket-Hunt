package com.project.MovieEventService.rabbitmq;

import lombok.Data;

import java.util.List;

@Data
public class BookingDTO {

    private String eventId;
    private String email;
    private String eventName;
    private String date;
    private String time;
    private String venue;
    private List<SeatsDTO> seatList;
    private int totalSeats;

    public BookingDTO(String eventId, String email, String eventName, String date, String time, String venue, List<SeatsDTO> seatList, int totalSeats) {
        this.eventId = eventId;
        this.email = email;
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.seatList = seatList;
        this.totalSeats = totalSeats;
    }
}
