package com.ozand.weatherapp.repository;

import com.ozand.weatherapp.entity.LogBilgi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogBilgiRepository extends JpaRepository<LogBilgi,Long> {
}
