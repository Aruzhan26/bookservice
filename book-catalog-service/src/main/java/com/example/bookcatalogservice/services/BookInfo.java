package com.example.bookcatalogservice.services;

import com.example.bookcatalogservice.models.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BookInfo {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Book book = restTemplate.getForObject("http://book-info-service/book/" + rating.getBookId(), Book.class);
        return new CatalogItem(book.getName(),"desc1",rating.getRating());
    }
    public CatalogItem getFallBackCatalogItem(Rating rating) {
        return new CatalogItem("Book not found","",rating.getRating());
    }
}
