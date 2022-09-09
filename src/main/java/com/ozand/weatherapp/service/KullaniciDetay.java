package com.ozand.weatherapp.service;

import com.ozand.weatherapp.entity.Kullanici;
import com.ozand.weatherapp.repository.KullaniciRepository;
import com.ozand.weatherapp.security.utils.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class KullaniciDetay implements UserDetailsService {


    @Autowired
    private KullaniciRepository kullaniciRepository;




    @Override
    public UserDetails loadUserByUsername(String kullaniciAdi) throws UsernameNotFoundException {
        Kullanici kullanici = kullaniciRepository.findKullaniciByKullaniciAdi(kullaniciAdi).orElseThrow();
        System.out.println(kullanici.getKullaniciRol().getIsim());
        return new MyUserDetails(kullanici);
    }

}
