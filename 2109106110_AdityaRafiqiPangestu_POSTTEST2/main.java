package Postest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

//-------------------- PROGRAM PENDATAAN MANAJEMEN VOUCHER KUOTA --------------------
class Voucher {
    private String voucher;
    private String paket;
    private String masa;
    private int kode;
    private int harga;

    public Voucher (String voucher, String paket, String masa, int kode, int harga) {
        this.voucher = voucher;
        this.paket = paket;
        this.masa = masa;
        this.kode = kode;
        this.harga = harga;
    }

    //----------VOUCHER----------
    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
    
    //----------PAKET----------
    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }
    
    //----------MASA----------
    public String getMasa() {
        return Masa;
    }

    public void setMasa(String Masa) {
        this.Masa = Masa;
    }
    
    //----------KODE----------
    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }
    
    //---------HARGA----------
    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    //----------DISPLAY----------
    public String toString () {
        return voucher + " | " + paket + " | " + masa + " | " + kode + " |Rp.  " + harga;
    }
}

//----------CLASS UTAMA----------
public class main {
    private static ArrayList<Voucher> daftarVoucher = new ArrayList<Voucher>();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    Scanner trm = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        boolean lanjutkan = true;
        
        while (lanjutkan) {
            System.out.println("VOUCHER KUOTA ADITYA CELL");
            System.out.println("----------------------------------");
            System.out.println("|              MENU              |");
            System.out.println("----------------------------------");
            System.out.println("| 1. Tambah Data                 |");
            System.out.println("| 2. Tampilkan Data              |");
            System.out.println("| 3. Hapus Data                  |");
            System.out.println("| 4. Update Data                 |");
            System.out.println("| 5. Keluar                      |");
            System.out.println("----------------------------------");

            System.out.print("\nPilih menu (1-5): ");
            String pilihan = input.readLine();

            switch (pilihan) {
                case "1":
                    tambahBarang();
                    break;
                case "2":
                    tampilkanBarang();
                    break;
                case "3":
                    hapusBarang();
                    break;
                case "4":
                    ubahBarang();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.err.println("Pilihan tidak tersedia \nSilahkan Input angka 1-5 ");
            }
            System.out.println("Apakah Anda Ingin Melanjutkan (y/n)?");
            pilihan = input.readLine();
            lanjutkan = pilihan.equalsIgnoreCase("y");
        }
    }

    //---------- TAMBAH DATA ----------
    private static void tambahBarang() throws IOException {
        System.out.print("Voucher      : ");
        String voucher = input.readLine();
        
        System.out.print("Paket     : ");
        String paket = input.readLine();
        
        System.out.print("Masa     : ");
        String masa = input.readLine();

        System.out.print("Kode     : ");
        int kode = Integer.parseInt(input.readLine());
        
        System.out.print("Harga     : Rp. ");
        int harga = Integer.parseInt(input.readLine());

        Voucher barang = new Voucher(voucher, paket, masa, kode, harga);
        daftarVoucher.add(barang);

        System.out.println("\n Data berhasil ditambahkan.");
    }

    //---------- MENAMPILKAN DATA ----------
    private static void tampilkanBarang() {
        System.out.println("\n--------- DAFTAR STOCK Voucher ----------");

        if (daftarVoucher.size() == 0) {
            System.out.println("Stock Voucher Kosong");
        } else {
            for (int i = 0; i < daftarVoucher.size(); i++) {
                System.out.println((i+1) + ". " + daftarVoucher.get(i));
            }
        }
    }

    //---------- UPDATE DATA -----------
    private static void ubahBarang() throws IOException {
        tampilkanBarang();

        if (daftarVoucher.size() == 0) {
            return;
        }

        System.out.print("\nPilih nomor data yang akan diubah: ");
        int nomor = Integer.parseInt(input.readLine());

        if (nomor < 1 || nomor > daftarVoucher.size()) {
            System.out.println("Nomor data tidak valid.");
            return;
        }

        Voucher barang = daftarVoucher.get(nomor-1);
        
        System.out.print("Voucher (" + barang.getVoucher() + "): ");
        String voucher = input.readLine();
        
        System.out.print("Paket (" + barang.getPaket() + "): ");
        String paket = input.readLine();
        
        System.out.print("Kode (" + barang.getKode() + "): ");
        int kode = Integer.parseInt(input.readLine());
        
        System.out.print("Masa (" + barang.getMasa() + "): ");
        String masa = input.readLine();
        
        System.out.print("Harga (" + barang.getHarga() + "): ");
        int harga = Integer.parseInt(input.readLine());
        
        barang.setVoucher(voucher);
        barang.setPaket(paket);
        barang.setKode(kode);
        barang.setMasa(masa);
        barang.setHarga(harga);

        System.out.println("\nData Voucher berhasil diubah.");
    }
    
    //----------- HAPUS DATA ----------
    private static void hapusBarang() throws IOException {
    tampilkanBarang();

    if (daftarVoucher.size() == 0) {
        return;
    }

    System.out.print("\nPilih nomor data yang akan dihapus: ");
    int nomor = Integer.parseInt(input.readLine());

    if (nomor < 1 || nomor > daftarVoucher.size()) {
        System.out.println("Nomor data tidak valid.");
        return;
    }

    Voucher barang = daftarVoucher.get(nomor-1);
    daftarVoucher.remove(barang);

    System.out.println("\nData berhasil dihapus.");
    }
}