package com.ozand.weatherapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GirisYapIstekDto {
    private String userName;
    private String password;

}
