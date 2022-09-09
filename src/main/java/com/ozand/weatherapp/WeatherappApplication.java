package com.ozand.weatherapp;

import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WeatherappApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {


		RestTemplate restTemplate = new RestTemplate();
		String havaDurumuVerisiResponse = restTemplate
				.getForObject("https://api.openweathermap.org/data/2.5/weather?q=istanbul&appid=04e63c2fa307aa353131ceda94419eaa&units=metric&lang=tr",String.class);

		JSONObject obj = new JSONObject(havaDurumuVerisiResponse);
		String pageName = obj.getJSONArray("weather").getJSONObject(0).getString("description");
		double sicaklik = obj.getJSONObject("main").getDouble("temp");
		System.out.println(sicaklik);

	}
}
