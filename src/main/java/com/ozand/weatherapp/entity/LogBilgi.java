package com.ozand.weatherapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "log_bilgiler")
public class LogBilgi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="ip_adresi")
    private String ipAdresi;
    @Column(name="sorgulama_zamani")
    private LocalDateTime sorgulamaZamani;
    @Column(name="sorgu_getirme_suresi")
    private String sorguGetirmeZamani;
    @Column(name="sorgu_sonuc")
    private String sorguSonuc;
    @Column(name="sorgu_durumu")
    private Boolean sorguDurumu;

    //Todo:İlişki Tablosu Belirtilecek one to many, many to one

    @ManyToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici;

    @ManyToOne
    @JoinColumn(name = "lokasyon_id")
    private Lokasyon lokasyon;

}
