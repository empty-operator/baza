package com.baza.controller;

import com.baza.entity.User;
import com.baza.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/funds/add")
@AllArgsConstructor
public class FundsController {

    private final UserService service;

    @GetMapping
    public String addFunds(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", service.findById(user.getId()).orElseThrow());
        return "add-funds";
    }

    @PostMapping
    public String addFunds(@AuthenticationPrincipal User principal, @RequestParam("amount") Integer amount) {
        User user = service.findById(principal.getId()).orElseThrow();
        Integer balance = Optional.ofNullable(user.getBalance()).orElse(0);
        user.setBalance(balance + amount);
        service.save(user);
        return "redirect:/profile";
    }

}
