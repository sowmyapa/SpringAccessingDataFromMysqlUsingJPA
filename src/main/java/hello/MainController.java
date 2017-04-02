package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sowmya on 3/16/17.
 */
@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path="email")
    public @ResponseBody User getUserByEmail(@RequestParam String email){
        return userRepository.findByEmail(email);
    }

    @GetMapping(path="name")
    public @ResponseBody Iterable<User> getUserByName(@RequestParam String name){
        return userRepository.findByName(name);
    }

    @GetMapping(path="user")
    public @ResponseBody User getUserByIdAndName(@RequestParam int id, @RequestParam String name){
        return userRepository.findByIdAndName(id, name);
    }
}
