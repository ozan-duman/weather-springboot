package com.ozand.weatherapp.service;

import com.ozand.weatherapp.entity.Lokasyon;
import com.ozand.weatherapp.repository.LokasyonRepository;

import java.util.List;

public class LokasyonService {
    private final LokasyonRepository lokasyonRepository;

    public LokasyonService(LokasyonRepository lokasyonRepository) {
        this.lokasyonRepository = lokasyonRepository;

    }

    public List<Lokasyon> listLokasyon(){

        return lokasyonRepository.findAll();

    }

    public  void save(Lokasyon lokasyon){

        lokasyonRepository.save(lokasyon);

    }

    public void update(Lokasyon lokasyon){

        Lokasyon gelenLokasyon = lokasyonRepository.findById(lokasyon.getId()).orElseThrow();
        gelenLokasyon.setIsim(lokasyon.getIsim());
        lokasyonRepository.save(gelenLokasyon);
    }

    public void deleteById(Long lokasyonId){

        lokasyonRepository.deleteById(lokasyonId);

    }

    public Lokasyon findById(Long lokasyonId){

        Lokasyon lokasyon = lokasyonRepository.findById(lokasyonId).orElseThrow();
        return lokasyon;
    }
}
