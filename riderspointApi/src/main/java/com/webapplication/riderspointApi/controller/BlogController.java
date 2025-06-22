package com.webapplication.riderspointApi.controller;


import com.webapplication.riderspointApi.entities.Blog;
import com.webapplication.riderspointApi.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/event")
    public String saveBlog(@RequestParam String blogTitle,
                           @RequestParam String blogDescription,
                           @RequestParam String blogLink) {
        Blog blog = new Blog();
        blog.setTitle(blogTitle);
        blog.setDescription(blogDescription);
        blog.setLink(blogLink);
        blogService.saveBlog(blog);
        return "redirect:/admin";
    }

    @GetMapping("/event")
    public String getAllBlogs(Model model) {
            model.addAttribute("blogs", blogService.getAllBlogs());
        return "blog";
    }
}