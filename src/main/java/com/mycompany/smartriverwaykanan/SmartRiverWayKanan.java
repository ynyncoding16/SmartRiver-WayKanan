package com.mycompany.smartriverwaykanan;

import java.util.Scanner;
// Tugas Gabungan LKP 2-5
public class SmartRiverWayKanan {

    // Overloading 1: Parameter String
    public static void cariSensor(String lokasi, SensorLingkungan[] daftar, int jumlah) {
        System.out.println("\n[Pencarian Teks] Hasil pencarian lokasi: \"" + lokasi + "\"");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getLokasiKecamatan().toLowerCase().contains(lokasi.toLowerCase())) {
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Sensor tidak ditemukan.");
    }

    // Overloading 2: Parameter int
    public static void cariSensor(int tahun, SensorLingkungan[] daftar, int jumlah) {
        System.out.println("\n[Pencarian Angka] Hasil pencarian tahun: " + tahun);
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getTahunPasang() == tahun) {
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Sensor tidak ditemukan.");
    }

    // Dynamic Binding / Upcasting Parameter
    public static void simulasiInspeksiSensor(SensorLingkungan sensor) {
        sensor.cekStatus();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array bertipe Superclass (Polymorphism)
        SensorLingkungan[] daftarSensor = new SensorLingkungan[20];
        int jumlahSensor = 0;

        // Data Awal (Dummy Data)
        daftarSensor[jumlahSensor++] = new SensorKetinggianAir("S-001", "Blambangan Umpu", 2024, 230);
        daftarSensor[jumlahSensor++] = new SensorCurahHujan("S-002", "Kasui", 2025, 65);
        daftarSensor[jumlahSensor++] = new CCTVBantaranSungai("C-001", "Baradatu", 2024, "4K Ultra HD");
        daftarSensor[jumlahSensor++] = new SensorKetinggianAir("S-003", "Bahuga", 2026, 120);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n========================================================");
            System.out.println("   SIMULATOR COMMAND CENTER SMART RIVER WAY KANAN       ");
            System.out.println("========================================================");
            System.out.println("1. Tambah Data Sensor Baru");
            System.out.println("2. Tampilkan Seluruh Data Sensor & Status Monitoring");
            System.out.println("3. Cari Sensor (Method Overloading)");
            System.out.println("4. Inspeksi Khusus Sensor (Dynamic Binding)");
            System.out.println("5. Keluar Aplikasi");
            System.out.print("Pilih Menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (jumlahSensor < daftarSensor.length) {
                        System.out.println("\n-- PILIH TIPE SENSOR --");
                        System.out.println("1. Sensor Ketinggian Air");
                        System.out.println("2. Sensor Curah Hujan");
                        System.out.println("3. CCTV Bantaran Sungai");
                        System.out.print("Pilihan (1/2/3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan ID Sensor (misal S-005): ");
                        String id = scanner.nextLine();
                        System.out.print("Masukkan Lokasi Kecamatan: ");
                        String lokasi = scanner.nextLine();
                        System.out.print("Masukkan Tahun Pemasangan: ");
                        int tahun = scanner.nextInt();
                        scanner.nextLine();

                        switch (jenis) {
                            case 1 -> {
                                System.out.print("Masukkan Ketinggian Air (cm): ");
                                int cm = scanner.nextInt();
                                scanner.nextLine();
                                daftarSensor[jumlahSensor++] = new SensorKetinggianAir(id, lokasi, tahun, cm);
                            }
                            case 2 -> {
                                System.out.print("Masukkan Curah Hujan (mm/jam): ");
                                int mm = scanner.nextInt();
                                scanner.nextLine();
                                daftarSensor[jumlahSensor++] = new SensorCurahHujan(id, lokasi, tahun, mm);
                            }
                            case 3 -> {
                                System.out.print("Masukkan Resolusi Kamera (misal 1080p): ");
                                String res = scanner.nextLine();
                                daftarSensor[jumlahSensor++] = new CCTVBantaranSungai(id, lokasi, tahun, res);
                            }
                        }
                        System.out.println(">> Data sensor berhasil disimpan!");
                    }
                }
                case 2 -> {
                    System.out.println("\n--------------------------------------------------------");
                    System.out.println("       DAFTAR SELURUH SENSOR SMART RIVER WAY KANAN      ");
                    System.out.println("--------------------------------------------------------");
                    for (int i = 0; i < jumlahSensor; i++) {
                        System.out.print((i + 1) + ". ");
                        daftarSensor[i].tampilkanInfo();
                        simulasiInspeksiSensor(daftarSensor[i]);
                        System.out.println();
                    }
                    System.out.println("Total Sensor Terdaftar: " + SensorLingkungan.totalSensor);
                }
                case 3 -> {
                    System.out.println("\n-- PILIH MODA PENCARIAN --");
                    System.out.println("1. Cari Berdasarkan Lokasi Kecamatan (Teks)");
                    System.out.println("2. Cari Berdasarkan Tahun Pemasangan (Angka)");
                    System.out.print("Pilih (1/2): ");
                    int mode = scanner.nextInt();
                    scanner.nextLine();

                    if (mode == 1) {
                        System.out.print("Masukkan Lokasi: ");
                        String kata = scanner.nextLine();
                        cariSensor(kata, daftarSensor, jumlahSensor);
                    } else if (mode == 2) {
                        System.out.print("Masukkan Tahun: ");
                        int angka = scanner.nextInt();
                        cariSensor(angka, daftarSensor, jumlahSensor);
                    }
                }
                case 4 -> {
                    System.out.print("\nMasukkan No Urut Sensor untuk Inspeksi (1-" + jumlahSensor + "): ");
                    int no = scanner.nextInt();
                    scanner.nextLine();
                    if (no >= 1 && no <= jumlahSensor) {
                        System.out.println("Hasil Inspeksi:");
                        daftarSensor[no - 1].tampilkanInfo();
                        simulasiInspeksiSensor(daftarSensor[no - 1]);
                    }
                }
                case 5 -> {
                    System.out.println("Keluar dari sistem...");
                    isRunning = false;
                }
            }
        }
        scanner.close();
    }
}