package com.ozand.weatherapp.service;

import com.ozand.weatherapp.entity.KullaniciRol;
import com.ozand.weatherapp.repository.KullaniciRolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KullaniciRolService {
    private final KullaniciRolRepository kullaniciRolRepository;

    public KullaniciRolService(KullaniciRolRepository kullaniciRolRepository){
    this.kullaniciRolRepository = kullaniciRolRepository;

    }

    public List<KullaniciRol> listKullaniciRol(){
        return kullaniciRolRepository.findAll();
    }

    public void save(KullaniciRol kullaniciRol){
        kullaniciRolRepository.save(kullaniciRol);
    }

    public void update(KullaniciRol kullaniciRol){
        KullaniciRol gelenKullaniciRol = kullaniciRolRepository.findById(kullaniciRol.getId()).orElseThrow();
        gelenKullaniciRol.setIsim(gelenKullaniciRol.getIsim());
        kullaniciRolRepository.save(gelenKullaniciRol);
    }

    public void deleteById(Long kullaniciRolId){
        kullaniciRolRepository.deleteById(kullaniciRolId);


    }

    public KullaniciRol findById(Long kullaniciRolId){
        KullaniciRol kullaniciRol = kullaniciRolRepository.findById(kullaniciRolId).orElseThrow();
        return kullaniciRol;
    }
}
