package com.ozand.weatherapp.controller;

import com.ozand.weatherapp.dto.GirisYapIstekDto;
import com.ozand.weatherapp.service.KullaniciService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KullaniciController {
    private final KullaniciService kullaniciService;

    public KullaniciController(KullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }
    /*@GetMapping("/login")
    public String login(){
        return "login/index";

    }*/
}
