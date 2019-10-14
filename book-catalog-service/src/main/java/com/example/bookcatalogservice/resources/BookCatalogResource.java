package com.example.bookcatalogservice.resources;

import com.example.bookcatalogservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        UserRating ratings = restTemplate.getForObject("http://book-rating-service/rating/users/"+userId, UserRating.class);
        UserReaded readings = restTemplate.getForObject("http://book-readed-service/readed/users/"+userId, UserReaded.class);

      return ratings.getUserRating().stream().map(rating -> {
            Book book = restTemplate.getForObject("http://book-info-service/book/" + rating.getBookId(), Book.class);

            /*Book book = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/book/" + rating.getBookId())
                    .retrieve()
                    .bodyToMono(Book.class)
                    .block();
*/
            return new CatalogItem(book.getName(),"desc1",rating.getRating());
        })
                .collect(Collectors.toList());

    }

    public String greeting(
            @PathVariable("userId") String userId, Model model
    ){
        String result = getCatalog(userId).toString();
        model.addAttribute(result);
        return "catalog";
    }
}
