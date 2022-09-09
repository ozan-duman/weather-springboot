package com.ozand.weatherapp.service;

import com.ozand.weatherapp.dto.GirisYapIstekDto;
import com.ozand.weatherapp.entity.Kullanici;
import com.ozand.weatherapp.entity.KullaniciRol;
import com.ozand.weatherapp.repository.KullaniciRepository;
import org.springframework.stereotype.Service;

@Service
public class KullaniciService {
    private final KullaniciRepository kullaniciRepository;
    private final KullaniciRolService kullaniciRolService;

    public KullaniciService(KullaniciRepository kullaniciRepository, KullaniciRolService kullaniciRolService) {
        this.kullaniciRepository = kullaniciRepository;
        this.kullaniciRolService = kullaniciRolService;
    }

    public boolean girisYap(GirisYapIstekDto girisYapIstekDto){
        Kullanici gelenKullanici = kullaniciRepository.findKullaniciByKullaniciAdi(girisYapIstekDto.getUserName()).orElseThrow();
        return gelenKullanici.getKullaniciAdi().equals(girisYapIstekDto.getUserName())
                && gelenKullanici.getSifre().equals(girisYapIstekDto.getPassword());

    }

    public void kaydet(Kullanici kullanici){
        kullaniciRepository.save(kullanici);
    }
}
