package com.baza.controller;

import com.baza.entity.Tariff;
import com.baza.service.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tariffs")
@AllArgsConstructor
public class TariffController {

    private final TariffService service;

    @GetMapping
    public String getTariffs(Model model) {
        model.addAttribute("tariffs", service.findAll());
        return "tariffs";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("tariff", new Tariff());
        return "tariffs/add";
    }

    @PostMapping
    public String save(@ModelAttribute("tariff") Tariff tariff) {
        service.save(tariff);
        return "redirect:/tariffs";
    }

    @PutMapping
    public String update(@ModelAttribute("tariff") Tariff tariff) {
        service.save(tariff);
        return "redirect:/tariffs";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tariff", service.findById(id));
        return "tariffs/edit";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/tariffs";
    }

}
