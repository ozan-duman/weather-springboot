package com.ozand.weatherapp.entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kullanicilar")
public class Kullanici {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="kullanici_adi")
    private String kullaniciAdi;
    @Column(name="adi")
    private String adi;
    @Column(name="soyadi")
    private String soyadi;
    @Column(name="sifre")
    private String sifre;


    @ManyToOne
    @JoinColumn(name = "rol_id")
    private KullaniciRol kullaniciRol;

    @OneToMany(mappedBy = "kullanici")
    private Set<LogBilgi> logBilgiler = new HashSet<>();



}
