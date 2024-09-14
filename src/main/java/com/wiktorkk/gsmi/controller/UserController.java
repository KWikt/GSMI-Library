package com.wiktorkk.gsmi.controller;

import com.wiktorkk.gsmi.dto.LoginRequest;
import com.wiktorkk.gsmi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, Model model) {
        if (userService.authenticate(loginRequest)) {
            return "index";
        } else {
            model.addAttribute("loginRequest", loginRequest);
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
