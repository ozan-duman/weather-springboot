package com.ozand.weatherapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozand.weatherapp.dto.HavaDurumuCevapDto;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class HavaDurumuService {

    private final RestTemplate restTemplate;

    private final String URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private final String APPKEY = "04e63c2fa307aa353131ceda94419eaa";
    private final String UNIT = "metric";
    private final String LANG = "tr";

    public HavaDurumuService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public HavaDurumuCevapDto havaDurumuGetir(String sehirIsmi){
        //"https://api.openweathermap.org/data/2.5/weather?q=istanbul&appid=04e63c2fa307aa353131ceda94419eaa&units=metric&lang=tr"
        String havaDurumuVerisiResponse = restTemplate
                .getForObject(URL + sehirIsmi + "&appid=" + APPKEY + "&units=" + UNIT + "&lang=" + LANG,String.class);

        JSONObject obj = new JSONObject(havaDurumuVerisiResponse);
        String havaAciklamasi = obj.getJSONArray("weather").getJSONObject(0).getString("description");
        double sicaklik = obj.getJSONObject("main").getDouble("temp");
        return HavaDurumuCevapDto.builder().aciklama(havaAciklamasi).sicaklik(sicaklik).sehirIsmi(sehirIsmi).build();

    }


}
