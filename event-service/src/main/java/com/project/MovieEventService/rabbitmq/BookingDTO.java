package com.project.MovieEventService.rabbitmq;

import lombok.Data;


@Data
public class BookingDTO {

    private String eventId;
    private String email;
    private String eventName;
    private String organizerName;
    private String date;
    private String time;
    private String venue;
    private byte[] image;
    private int totalSeats;
    private String eventType;

    public BookingDTO(String eventId, String email, String eventName, String organizerName, String date, String time, String venue, byte[] image, int totalSeats, String eventType) {
        this.eventId = eventId;
        this.email = email;
        this.eventName = eventName;
        this.organizerName = organizerName;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.image = image;
        this.totalSeats = totalSeats;
        this.eventType = eventType;
    }


}
