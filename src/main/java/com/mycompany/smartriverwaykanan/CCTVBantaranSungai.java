package com.mycompany.smartriverwaykanan;

public class CCTVBantaranSungai extends SensorLingkungan {
    private String resolusiKamera;

    public CCTVBantaranSungai(String id, String lokasi, int tahun, String resolusiKamera) {
        super(id, lokasi, tahun);
        this.resolusiKamera = resolusiKamera;
    }

    public String getResolusiKamera() { return this.resolusiKamera; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[CCTV Surveillance ] ");
        super.tampilkanInfo();
        System.out.printf(" | Resolusi: %s%n", this.resolusiKamera);
    }

    @Override
    public void cekStatus() {
        System.out.println("   [LIVE] Streaming CCTV Aktif. Visual sungai terpantau lancar.");
    }
}