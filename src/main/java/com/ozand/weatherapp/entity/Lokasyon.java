package com.ozand.weatherapp.entity;

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
@Table(name = "lokasyon")
public class Lokasyon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="isim")
    private String isim;

    @OneToMany(mappedBy = "lokasyon")
    private Set<LogBilgi> logBilgiler = new HashSet<>();
}
