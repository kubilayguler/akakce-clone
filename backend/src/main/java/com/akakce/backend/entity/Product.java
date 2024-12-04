package com.akakce.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "URUNLER")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "marka")
    private String marka;

    @Column(name = "model_adi")
    private String modelAdi;

    @Column(name = "model_no")
    private String modelNo;

    @Column(name = "isletim_sistemi")
    private String isletimSistemi;

    @Column(name = "islemci_tipi")
    private String islemciTipi;

    @Column(name = "islemci_nesili")
    private String islemciNesili;

    @Column(name = "ram")
    private int ram;

    @Column(name = "disk_boyutu")
    private String diskBoyutu;

    @Column(name = "disk_tipi")
    private String diskTipi;

    @Column(name = "ekran_boyutu")
    private double ekranBoyutu;

    @Column(name = "puan")
    private double puan;

    @Column(name = "fiyat")
    private float fiyat;

    @Column(name = "site_adi")
    private String siteAdi;

    @Column(name = "urun_resim_linki")
    private String urunResimLinki;

    @Column(name = "site_logo_linki")
    private String siteLogoLinki;
}
