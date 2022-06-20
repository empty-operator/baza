package com.baza.controller;

import com.baza.entity.User;
import com.baza.service.ConnectionService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/connections")
@AllArgsConstructor
public class ConnectionController {

    private final ConnectionService connectionService;

    @PostMapping
    public String create(@RequestParam("tariff") Long tariffId,
                         @RequestParam("address") String address,
                         @AuthenticationPrincipal User principal) {
        connectionService.create(tariffId, address, principal);
        return "redirect:/profile";
    }

    @PutMapping
    public String changeStatus(@RequestParam("connection") Long connectionId, @RequestParam("status") String status) {
        connectionService.changeStatus(connectionId, status);
        return "redirect:/requests";
    }

}
