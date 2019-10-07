package com.example.bookreadedservice.resources;

import com.example.bookreadedservice.models.Readed;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readed")
public class ReadedBookResource {

    @RequestMapping("/{userId}")
    public Readed getReadedBook(@PathVariable("userId") String userId){
        return new Readed(userId, "8");
    }
}
