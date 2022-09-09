package com.ozand.weatherapp.controller;

import com.ozand.weatherapp.dto.HavaDurumuCevapDto;
import com.ozand.weatherapp.dto.HavaDurumuRequestDto;
import com.ozand.weatherapp.service.HavaDurumuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnasayfaController {

    private final HavaDurumuService havaDurumuService;

    public AnasayfaController(HavaDurumuService havaDurumuService) {
        this.havaDurumuService = havaDurumuService;
    }

    @GetMapping("/index")
    public String anasayfaGoster(Model model){
        HavaDurumuCevapDto havaDurumuCevapDto = havaDurumuService.havaDurumuGetir("istanbul");
        model.addAttribute("havaDurumuGetir",havaDurumuCevapDto);
        return "/home/index";
    }

    @ModelAttribute("havaDurumuRequestDto")
    public HavaDurumuRequestDto havaDurumuRequestDto() {
        return new HavaDurumuRequestDto();
    }

    @PostMapping(value="/hava-durumu/getir")
    public String havaDurumuGetir(@ModelAttribute("havaDurumuRequestDto") HavaDurumuRequestDto havaDurumuRequestDto, Model model){
        HavaDurumuCevapDto havaDurumuCevapDto = havaDurumuService.havaDurumuGetir(havaDurumuRequestDto.getSehirAdi().toLowerCase());
        model.addAttribute("havaDurumuGetir",havaDurumuCevapDto);
        return "/home/index";
    }



}
