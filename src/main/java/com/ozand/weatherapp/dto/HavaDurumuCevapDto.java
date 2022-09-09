package com.ozand.weatherapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HavaDurumuCevapDto {

    private String sehirIsmi;
    private double  sicaklik;
    private String aciklama;

}
