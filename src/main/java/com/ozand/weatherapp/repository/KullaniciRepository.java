package com.ozand.weatherapp.repository;

import com.ozand.weatherapp.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KullaniciRepository extends JpaRepository<Kullanici,Long> {
    Optional<Kullanici> findKullaniciByKullaniciAdi(String kullaniciAdi);

}
