package com.example.bookreadedservice.resources;

import com.example.bookreadedservice.models.Readed;
import com.example.bookreadedservice.models.UserReaded;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/readed")
public class ReadedBookResource {

    @RequestMapping("/{bookId}")
    public Readed getReadedBook(@PathVariable("bookId") String bookId){

        return new Readed(bookId,"YES");
    }
    @RequestMapping("/users/{userId}")
    public UserReaded getUserReadedBook(@PathVariable("userId") String userId){
        List<Readed> readings = Arrays.asList(
                new Readed("123","yes") ,
                new Readed("456","no")
        );
        UserReaded userReaded = new UserReaded();
        userReaded.setUserReaded(readings);

        return userReaded;
    }

}
