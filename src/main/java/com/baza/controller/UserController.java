package com.baza.controller;

import com.baza.entity.User;
import com.baza.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String save(@ModelAttribute("user") User user) {
        service.register(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", service.findById(user.getId()).orElseThrow());
        return "profile";
    }

}
