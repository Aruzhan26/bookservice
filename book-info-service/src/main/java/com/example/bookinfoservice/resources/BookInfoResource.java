package com.example.bookinfoservice.resources;

import com.example.bookinfoservice.models.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookInfoResource {

    @RequestMapping("/{bookId}")
    public Book getBookInfo(@PathVariable("bookId") String bookId){
        return new Book(bookId, "BOOK1") ;

    }
}
