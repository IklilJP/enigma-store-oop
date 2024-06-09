package com.enigma.gosling;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    ProductServiceImpl service = new ProductServiceImpl();

    public void menu() {
        System.out.println("-".repeat(20));
        System.out.println("Main Menu");
        System.out.println("-".repeat(20));
        System.out.println("1. Tambah Produk");
        System.out.println("2. Ubah Produk");
        System.out.println("3. Hapus Produk");
        System.out.println("4. Lihat Semua Produk");
        System.out.println("5. Cari Produk Berdasarkan");
        System.out.println("6. Keluar");
        System.out.print("Masukkan Pilihan : ");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Tambah Produk");
                addProduct();
                break;
            case "2":
                System.out.println("Ubah Produk");
                updateProduct();
                break;
            case "3":
                System.out.println("Hapus Produk");
                deleteProduct();
                break;
            case "4":
                System.out.println("Lihat Semua Produk");
                viewProduct();
                break;
            case "5":
                System.out.println("Cari Produk Berdasarkan");
                searchProduct();
                break;
            case "6":
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid Choice");
                menu();
        }
    }

    private void addProduct() {
        System.out.println("-".repeat(20));
        System.out.println("Add Product");
        System.out.println("-".repeat(20));
        String name;
        String brand;
        int price;
        do {
            System.out.println("Masukkan Nama Produk : ");
            name = sc.nextLine();
            name = name.trim();
        } while (name.length() < 3 || name.length() > 50);

        do {
            System.out.println("Masukkan Brand : ");
            brand = sc.nextLine();
            brand = brand.trim();
        } while (brand.length() < 3 || brand.length() > 30);

        do {
            String temp;
            System.out.println("Masukkan Harga : ");
            temp = sc.nextLine();
            if (temp.isBlank()) {
                price = 0;
                break;
            } else if (!temp.matches("[0-9]+")) {
                System.out.println("Harga harus berupa angka tidak boleh kosong dan negatif");
                price = -1;
                continue;
            }
            price = Integer.parseInt(temp);
        } while (price < 0);
        service.addProduct(new Product(LocalDate.now(), service.idproduct, name, brand, price));
        menu();
    }

    private void updateProduct() {
        System.out.println("-".repeat(20));
        System.out.println("Update Product");
        System.out.println("-".repeat(20));
        String name;
        String brand;
        int price;
        int idproduct;

        do {
            System.out.println("Masukkan ID produk yang ingin di ubah : ");
            String idtemp = sc.nextLine();
            if (idtemp.matches("[0-9]+")) {
                idproduct = Integer.parseInt(idtemp);
            } else {
                System.out.println("ID harus berupa angka !");
                idproduct = 0;
            }
        } while (idproduct < 1);

        do {
            System.out.println("Masukkan Nama produk : ");
            name = sc.nextLine();
            name = name.trim();
            if (name.isBlank()) {
                break;
            }
        } while (name.length() < 3 || name.length() > 50);


        do {
            System.out.println("Masukkan Brand : ");
            brand = sc.nextLine();
            brand = brand.trim();
            if (brand.isBlank()) {
                break;
            }
        } while (brand.length() < 3 || brand.length() > 30);

        do {
            String temp;
            System.out.println("Masukkan Harga : ");
            temp = sc.nextLine();
            if (temp.isBlank()) {
                price = 0;
                break;
            } else if (!temp.matches("[0-9]+")) {
                System.out.println("Harga harus berupa angka tidak boleh kosong dan negatif");
                price = -1;
                continue;
            }
            price = Integer.parseInt(temp);
        } while (price < 0);
        service.updateProduct(idproduct, new Product(LocalDate.now(), idproduct, name, brand, price));
        menu();

    }

    private void deleteProduct() {
        System.out.println("Masukkan ID produk yang ingin di hapus");
        int id = Integer.parseInt(sc.nextLine());
        service.deleteProduct(id);
        menu();
    }

    private void searchProduct() {
        System.out.println("Masukkan Nama produk yang ingin di cari");
        String name = sc.nextLine();
        service.searchProduct(name);
        menu();
    }

    private void viewProduct() {
        service.viewProduct();
        menu();
    }

}
