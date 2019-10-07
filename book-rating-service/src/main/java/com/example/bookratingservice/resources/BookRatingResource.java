package com.example.bookratingservice.resources;

import com.example.bookratingservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class BookRatingResource {

    @RequestMapping("/{bookId}")
    public Rating getBookRating(@PathVariable("bookId") String bookId){
        return new Rating(bookId, 5);
    }
}
