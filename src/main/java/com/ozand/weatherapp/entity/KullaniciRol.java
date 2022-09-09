package com.ozand.weatherapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "kullanici_roller")
public class KullaniciRol {
    @Id //Id vererek bu keyin primary key olduğunu belirtilir.//
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Bunun otomatik arttığını belirtir.//
    private Long id;
    @Column(name="isim")
    private String isim;

    @OneToMany(mappedBy = "kullaniciRol")
    private Set<Kullanici> kullanicilar = new HashSet<>();

}
