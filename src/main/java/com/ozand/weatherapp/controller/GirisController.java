package com.ozand.weatherapp.controller;


import com.ozand.weatherapp.entity.Kullanici;
import com.ozand.weatherapp.entity.KullaniciRol;
import com.ozand.weatherapp.service.KullaniciDetay;
import com.ozand.weatherapp.service.KullaniciService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GirisController {
    private KullaniciService kullaniciService;
    private PasswordEncoder passwordEncoder;

    public GirisController(KullaniciService kullaniciService, PasswordEncoder passwordEncoder) {
        this.kullaniciService = kullaniciService;
        this.passwordEncoder = passwordEncoder;
    }

    //Http gelen login isteklerini burada karşılıyoruz.Kontrol ediyor, doğru değilse login'e geri atıyor.

    @GetMapping("/login")
    public String showLoginPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(authentication.getDetails());
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "/login/index";
        }
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }

    @GetMapping("/login/register")
    public String showRegisterPage(Model model){
        model.addAttribute("kullanici",new Kullanici());
        return "/login/register";
    }

    @PostMapping("/login/registration-process")
    public String registrationProcess(Kullanici kullanici){
        kullanici.setSifre(passwordEncoder.encode(kullanici.getSifre()));
        kullaniciService.kaydet(kullanici);
        return "redirect:/login/index";
    }


}
