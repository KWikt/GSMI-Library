package com.wiktorkk.gsmi.controller;


import com.wiktorkk.gsmi.model.User;
import com.wiktorkk.gsmi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String start(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }


    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "index";
    }
}
