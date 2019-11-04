package com.example.bookcatalogservice.resources;

import com.example.bookcatalogservice.models.*;
import com.example.bookcatalogservice.services.BookInfo;
import com.example.bookcatalogservice.services.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    BookInfo boonInfo;

    @Autowired
    UserRatingInfo userRatingInfo;

    @RequestMapping("/{userId}")
    @HystrixCommand(fallbackMethod = "getFallBackCatalog")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        UserRating ratings = userRatingInfo.getUserRating(userId);
        UserReaded readings = getUserReaded(userId);

        return ratings.getUserRating().stream()
                .map(rating -> boonInfo.getCatalogItem(rating))
                .collect(Collectors.toList());

    }
    public List<CatalogItem> getFallBackCatalog(@PathVariable("userId") String userId){
        return Arrays.asList(new CatalogItem("No book","",0));
    }

    private UserReaded getUserReaded(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://book-readed-service/readed/users/"+userId, UserReaded.class);
    }

}
