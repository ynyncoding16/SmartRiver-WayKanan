package com.mycompany.smartriverwaykanan;

public class SensorCurahHujan extends SensorLingkungan {
    private int curahHujanMm;

    public SensorCurahHujan(String id, String lokasi, int tahun, int curahHujanMm) {
        super(id, lokasi, tahun);
        this.curahHujanMm = curahHujanMm;
    }

    public int getCurahHujanMm() { return this.curahHujanMm; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Sensor Rainfall   ] ");
        super.tampilkanInfo();
        System.out.printf(" | Curah Hujan: %d mm/jam%n", this.curahHujanMm);
    }

    @Override
    public void cekStatus() {
        if (this.curahHujanMm > 50) {
            System.out.println("   [PERINGATAN] Hujan Lebat Terdeteksi! Waspada erosi & luapan sungai.");
        } else {
            System.out.println("   [AMAN] Curah hujan ringan/sedang. Kondisi stabil.");
        }
    }
}