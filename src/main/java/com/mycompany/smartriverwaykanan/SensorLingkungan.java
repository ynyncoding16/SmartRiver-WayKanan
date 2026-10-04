package com.mycompany.smartriverwaykanan;

public class SensorLingkungan {
    // Encapsulation (Private Field)
    private String idSensor;
    private String lokasiKecamatan;
    private int tahunPasang;
    
    // Static Variable (Milik bersama/Counter)
    public static int totalSensor = 0;

    // Constructor dengan keyword 'this'
    public SensorLingkungan(String idSensor, String lokasiKecamatan, int tahunPasang) {
        this.idSensor = idSensor;
        this.lokasiKecamatan = lokasiKecamatan;
        this.tahunPasang = tahunPasang;
        totalSensor++;
    }

    // Getter dan Setter
    public String getIdSensor() { return this.idSensor; }
    public String getLokasiKecamatan() { return this.lokasiKecamatan; }
    public int getTahunPasang() { return this.tahunPasang; }

    public void setTahunPasang(int tahunPasang) {
        if (tahunPasang > 2000) {
            this.tahunPasang = tahunPasang;
        } else {
            System.out.println("Tahun tidak valid!");
        }
    }

    // Method dasar (akan di-override oleh Subclass)
    public void tampilkanInfo() {
        System.out.printf("ID: %-8s | Lokasi: %-16s | Thn: %d", 
                this.idSensor, this.lokasiKecamatan, this.tahunPasang);
    }

    public void cekStatus() {
        System.out.println("-> Status: Sensor memantau kondisi lingkungan umum.");
    }
}