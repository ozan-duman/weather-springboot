package com.ozand.weatherapp.repository;

import com.ozand.weatherapp.entity.Lokasyon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LokasyonRepository extends JpaRepository<Lokasyon,Long> {
}
