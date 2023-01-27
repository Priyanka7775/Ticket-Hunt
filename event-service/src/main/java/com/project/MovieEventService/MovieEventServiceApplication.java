package com.project.MovieEventService;

import com.project.MovieEventService.domain.Event;
import com.project.MovieEventService.proxy.BookingProxy;
import com.project.MovieEventService.repository.EventRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@EnableEurekaClient
public class MovieEventServiceApplication {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private BookingProxy bookingProxy;

    @PostConstruct
    public void events() {

        byte[] bytes = new byte[0];
        try {
            File file1 = new File("event-service/src/main/resources/images/q.jpg");
            bytes = FileUtils.readFileToByteArray(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Event> events = Stream.of(
                new Event("1100", "aman.gupta4692@gmail.com", "Dance Today", "Dance INC",
                        "30-01-2022", "10:00 AM", "JLN Stadium", bytes, 50, "event",
                        "Dance Competition", 300, "9")
        ).collect(Collectors.toList());
        eventRepository.saveAll(events);

        for (Event e : events) {
            bookingProxy.saveBooking(e);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieEventServiceApplication.class, args);
    }

}
