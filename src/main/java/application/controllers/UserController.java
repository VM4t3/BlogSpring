package application.controllers;


import application.models.Blog;
import application.models.BlogUser;
import application.models.UserRole;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/user")
    public BlogUser getUser(){
       return service.loadUserByUsername("M4t3");

    }

    @GetMapping(value = {"/users/", "/users/{username}"})
    public BlogUser getOneUser(
            @PathVariable("username") String username
    ) {
        if (username != null) {
            return service.loadUserByUsername(username);
        }
        return null;
    }

    @GetMapping("/users")
    public List<BlogUser> getAllUser(){
        List<BlogUser> users =  service.getAllUsers();

        return users;
    }

    @PostMapping("/register")
    public void createNewUser(@RequestBody BlogUser user) {
        service.registerUsers(user);

    }





}
