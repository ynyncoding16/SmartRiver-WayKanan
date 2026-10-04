package com.mycompany.smartriverwaykanan;

public class SensorKetinggianAir extends SensorLingkungan {
    private int ketinggianAirCm;

    public SensorKetinggianAir(String id, String lokasi, int tahun, int ketinggianAirCm) {
        super(id, lokasi, tahun); // Keyword 'super'
        this.ketinggianAirCm = ketinggianAirCm;
    }

    public int getKetinggianAirCm() { return this.ketinggianAirCm; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Sensor Water Level] ");
        super.tampilkanInfo();
        System.out.printf(" | Ketinggian Air: %d cm%n", this.ketinggianAirCm);
    }

    @Override
    public void cekStatus() {
        if (this.ketinggianAirCm > 200) {
            System.out.println("   [PERINGATAN] SIAGA BANJIR! Air melampaui batas aman (>200 cm).");
        } else {
            System.out.println("   [AMAN] Status Normal: Aliran air sungai dalam batas aman.");
        }
    }
}