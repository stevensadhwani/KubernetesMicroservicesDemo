package com.sadhwani.kubernetes.UserManagementService.User;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {


    public UserController(UserRepository repository){
        this.repository = repository;
    }

    private UserRepository repository;

    @CrossOrigin
    @RequestMapping("/signup")

    public User signupUser(@RequestBody Map<String,String> payload){
        String username = payload.get("username");
        String password = payload.get("password");

        User user = new User();

        user.setPassword(password);
        user.setUsername(username);
        return repository.save(user);
    }


    @CrossOrigin
    @RequestMapping("/login")

    public User loginUser(@RequestBody Map<String,String> payload){
        String username = payload.get("username");
        String password = payload.get("password");

        List<User> users = repository.findByUsernameAndPassword(username,password);

        if(!users.isEmpty()){
            return users.get(0);
        }

        else
            return null;

    }


}
