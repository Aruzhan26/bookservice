package com.example.bookratingservice.resources;

import com.example.bookratingservice.models.Rating;
import com.example.bookratingservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class BookRatingResource {

    @RequestMapping("/{bookId}")
    public Rating getBookRating(@PathVariable("bookId") String bookId){
        return new Rating(bookId, 5);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){

        List<Rating> ratings = Arrays.asList(
                new Rating("123",5) ,
                new Rating("456",4)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;
    }
}
