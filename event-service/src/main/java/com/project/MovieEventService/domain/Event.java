package com.project.MovieEventService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Event {
    @Id
    private String eventId;
    private String email;
    private String eventName;
    private String organizerName;
    private String date;
    private String time;
    private String venue;
    private String image;
   private int totalSeat;


}
