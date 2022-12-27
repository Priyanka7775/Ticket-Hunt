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
<<<<<<< HEAD
    private int totalSeat;
    private String eventType;
=======
   private int totalSeat;
   private String eventType;
>>>>>>> 5050aa6a75fbc2b1172714b1556f379f29a02f49


}
