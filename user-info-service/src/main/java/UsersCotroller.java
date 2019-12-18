import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersCotroller {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String hello(){
        return "Hello, It's user page";
    }
    @PostMapping("/add")
    public Users createUser(@Valid @RequestBody Users user) {
        return userRepository.save(user);
    }

    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Users getUserById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        return user;
    }
    @GetMapping("/user/{userName}")
    public Users getUserByUserName(@PathVariable(value = "userName") String userName)
            throws ResourceNotFoundException {
        Users user = userRepository.findUsersByUserName(userName);
        return user;
    }
    @GetMapping("/user/{email}")
    public Users getUserByEmail(@PathVariable(value = "email") String email) throws ResourceNotFoundException{
        Users user = userRepository.findUsersByEmail(email);
        return user;
    }
}
