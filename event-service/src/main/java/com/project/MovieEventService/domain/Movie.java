package com.project.MovieEventService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    private String movieId;

    private String movieName;

    private String date;
    private String time;
    private String venue;
    private String image;
    private int totalSeat;

}
