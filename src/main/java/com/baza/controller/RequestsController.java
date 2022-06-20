package com.baza.controller;

import com.baza.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/requests")
@AllArgsConstructor
public class RequestsController {

    private final UserService service;

    @GetMapping
    public String getRequests(Model model) {
        model.addAttribute("requests", service.findAllUsers());
        return "requests";
    }

}
