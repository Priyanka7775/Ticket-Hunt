package com.project.MovieEventService;

import com.project.MovieEventService.domain.Event;
import com.project.MovieEventService.proxy.BookingProxy;
import com.project.MovieEventService.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<Event> events = new ArrayList<>();
        List<File> imageFiles = Arrays.asList(new File("sita.jpg"), new File("jersey.jpg"), new File("bhool.jpeg"), new File("drishyam.jpg"),
                new File("phone.jpg"), new File("khuda.jpg"),new File("jug.jpg"), new File("food.jpg"),new File("joy.jpg"),new File("arijit.png"), new File("model.jpg"), new File("craft.jpg"));

        try {
            events = Stream.of(
                new Event("1", "a", "Sita-Ramam", "a", "2023-08-05", "2h 43m", "a", bytes, 50, "movie", "Sita Ramam is a 2022 Indian Telugu-language period romance film written and directed by Hanu Raghavapudi. Produced by Vyjayanthi Movies and Swapna Cinema, the film stars Dulquer Salmaan and Mrunal Thakur (in her Telugu debut) in lead roles with Rashmika Mandanna in a major role and Sumanth in the supporting role.", 111, "8.6/10"),
                new Event("3", "a", "Jersey", "a", "2023-04-22", "02:50", "a", bytes, 50, "movie", "In 1986 in Hyderabad, Arjun is an immensely talented Ranji (First-class cricketer) player who is in love with Sarah. Arjun quits cricket when he repeatedly gets rejected to play in the Indian team, due to selection politics. He is given a government job under sports quota, but loses it when he is accused of bribery", 111, "7.3/10"),
                new Event("4", "a", "Bhool Bhulaiyaa 2", "a", "2022-05-20", "2h 25m", "a", bytes, 50, "movie", "Across a mansion in Bhawanigarh, Rajasthan in 2004, the priests confine a malevolent spirit named Manjulika, who is hell-bent on attacking the family's daughter-in-law Anjulika to a room. After this, the family deserts the mansion for safety.After an accident, Ruhan agrees to accompany Reet back home. However, due to a series of untimely incidents, he gets caught up in her family's skirmish.", 111, "5.7/10"),
                new Event("5", "a", "Drishyam 2", "a", "2023-11-18", "14:12", "a", bytes, 50, "movie", "Drishyam 2 is a 2022 Indian Hindi-language crime thriller film directed by Abhishek Pathak, adapted from the 2021 Malayalam film of the same name, and a sequel to the 2015 film Drishyam. Produced by Pathak and his father Kumar Mangat Pathak under the Panorama Studios banner alongside Viacom18 Studios, with Bhushan Kumar and Krishan Kumar joining as producers under the T-Series Films banner.", 111, "8.4/10"),
                new Event("8", "a", "Phone Boot", "a", "2023-11-04", "2:16", "a", bytes, 50, "movie", "Major and Gullu two friends who are obsessed with horror since childhood want to make their careers on something related to it but whatever business they have started always failed.During one Halloween party they come across an unknown beautiful women and cant get over her she traces them to their house and discloses that she is a ghost and they can interact with her normally as they have been god gifted with some powers.", 111, "5.7/10"),
                new Event("9", "a", "Khuda Haafiz 2", "a", "2023-07-08", "02:29", "a", bytes, 50, "movie", "After busting down the flesh traders in Noman and saving his wife Nargis, Sameer returns to India with Nargis, who battles depression and PTSD after the Noman incident. One year later, where the couple try to find their new normal but are seen to be struggling, despite therapy and medicines.Sameer's best friend Deepak loses his brother and sister-in-law to a car accident and they are survived by their 5-year old daughter, Nandini. However, due to his sales job", 111, "7.5/10"),
                new Event("10", "a", "Jug Jugg Jeeyo", "a", "2023-06-24", "2h 30m", "a", bytes, 50, "movie", "Kuldeep Kukoo Saini and Nainaa Sharma marry each other, having loved each other ever since they had gone to school together. The couple relocate to Toronto, Canada for Nainaa's job in a corporate company while Kukoo is employed as a bouncer in a nightclub. Within five years, the couple's marital life gets strained due to prolonged silences, unfinished conversations and resentful hearts while Nainaa is offered a new position as the vice-president of HR at New York City and Kukoo is frustrated with his job.", 111, "6.1/10"),
                new Event("20", "a", "Cosmo-Food Carnival", "a", "13 Febuary 2023", "6:00PM-12 Mid-night", "a", bytes, 50, "event", "A food festival is a festival, that uses food, often produce, as its central theme. These festivals have always been a means of uniting communities through celebrations of harvests and giving thanks for a plentiful growing season.Food Festivals throughout the world are often based on traditional farming techniques, seasons Food festivals are related to food culture of an area, whether through the preparation of food served or the time period in which the festival is celebrated.", 111, "9.3/10"), new Event("19", "a", "Joy Town", "a", "3 Febuary 2023", "10:00Am Onwards", "a", bytes, 50, "event", "Come on down to a one-of-a-kind festival that's going to be an edge-of-your-seat joyride and the talk of the town. Get insider access to the thrilling world of BMW motoring as you get your drift mode on in a BMW, witness insane stunts by BMW Motorrad riders, and experience that go-kart feeling in a MINI. Groove to the beats and tunes of your favourite artists.Indulge in culinary delights and wash it all down with a beer at our exclusive beer garden. Or if you fancy a cocktail, our mixologists will be keeping the mood high and the vibe heady well into the evening.", 111, "7/10"), new Event("18", "a", "Arijit Singh Concert", "a", "13 Febuary 2023", "10:00PM-1:00AM", "a", bytes, 50, "event", "Arijit Singh is an Indian musician, singer, composer, music producer, recordist and a music programmer. At the age of 3, he started training under Hazari brothers, and at the age of 9, he got a scholarship from the government for training in vocals in Indian classical music. He predominantly sings in Hindi and Bengali, but has also lent his voice to various other Indian languages. Singh is regarded as one of the most versatile and successful singers in the History of Indian Music and Hindi Cinema.", 111, "8.8/10"),
                new Event("17", "a", "Miss Supermodel Globe", "a", "10 Febuary 2023", "12:30PM-2:00PM", "a", bytes, 50, "event", "Miss SuperModel Globe is an International Beauty Pageant, A Influential platform for Young Women to make a Mark in the Global World of Modelling With a Fasion to “Educate MEN, Save & Empower Women.Miss SuperModel Globe is not just a Beauty Pageant, participating in the Pageant will give you International Exposure and Experience, Propel your career growth Internationally.", 111, "6.8/10"), new Event("14", "a", "Art and Craft Fair", "a", "31 January 2023", "7:30PM-11:00PM", "a", bytes, 50, "event", "Arts and crafts show is a place where works are displayed and sold to a broader sect of buyers. Arts and crafts show is a perfect medium of marketing where the artisans can have a direct contact with larger group of people. The basic nature of such shows varies depending upon the region, climatic condition of the region and the quality of crowd gathered in a fair. ", 111, "7.7/10")
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < imageFiles.size(); i++) {
            try {
                File imageFile = imageFiles.get(i);
                bytes = Files.readAllBytes(imageFile.toPath());
                events.get(i).setImage(bytes);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        eventRepository.saveAll(events);

        for (Event e: events) {
            bookingProxy.saveBooking(e);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieEventServiceApplication.class, args);
    }

}
