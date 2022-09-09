package com.ozand.weatherapp.security.utils;

import com.ozand.weatherapp.entity.Kullanici;
import com.ozand.weatherapp.entity.KullaniciRol;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {
    private Kullanici kullanici;

    public MyUserDetails(Kullanici kullanici) {
        this.kullanici = kullanici;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //Login olan kullanıcının rolleri alındı.
        KullaniciRol rol = kullanici.getKullaniciRol();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(rol.getIsim()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return kullanici.getSifre();
    }

    @Override
    public String getUsername() {
        return kullanici.getKullaniciAdi();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
