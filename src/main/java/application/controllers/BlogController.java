package application.controllers;

import application.models.Blog;
import application.service.BlogServices;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogController {

    private BlogServices service;

    @Autowired
    public BlogController(BlogServices service) {
        this.service = service;
    }

    /* végtelen ciklusba ragad :(*/
    /*
    @GetMapping("/blog")
    public List<Blog> getAllBlog(){
        List<Blog> blogs = new ArrayList<>();
        blogs   = service.getAllBlogs();
        return blogs;
    }
   */

    @GetMapping("/blogs")
    public void presistBlog() {
        service.presistBlog();

    }


}
