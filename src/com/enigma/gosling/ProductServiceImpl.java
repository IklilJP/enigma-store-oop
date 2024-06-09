package com.enigma.gosling;

import com.enigma.gosling.Service.ProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products = new ArrayList<>();

    int idproduct = 1;
    LocalDate datproduck = LocalDate.now();

    @Override
    public void addProduct(Product Product) {
        Product.setDate(datproduck);
        Product.setId(idproduct);
        products.add(Product);
        idproduct++;
    }

    @Override
    public void deleteProduct(int id) {
        int index = -1;
        int i = 0;
        while (i < products.size()) {
            if (products.get(i).getId() == id) {
                index = i;
                break;
            }
            i++;
        }
        if (index != -1) {
            products.remove(index);
        } else {
            System.out.println("Produk Tidak Ditemukan ");
        }
    }

    @Override
    public void updateProduct(int idproduct, Product product) {
        int index = -1;
        int i = 0;
        while (i < products.size()) {
            if (products.get(i).getId() == idproduct) {
                index = i;
                break;
            }
            i++;
        }
        if (index != -1) {
            if (product.getName().isEmpty()) {
                product.setName(products.get(index).getName());
            }
            if (product.getBrand().isEmpty()) {
                product.setBrand(products.get(index).getBrand());
            }
            if (product.getPrice() == 0) {
                product.setPrice(products.get(index).getPrice());
            }
            product.setDate(products.get(index).getDate());
            products.set(index, product);
        } else {
            System.out.println("Produk dengan id " + idproduct + " tidak ditemukan");
        }
    }

    @Override
    public void viewProduct() {
        for (Product product : products) {
            System.out.println("-".repeat(20));
            System.out.println("Id produk : " + product.getId());
            System.out.println("tanggal produk : " + product.getDate());
            System.out.println("Nama produk : " + product.getName());
            System.out.println("Nama brand : " + product.getBrand());
            System.out.println("Harga produk : " + product.getPrice());
            System.out.println("-".repeat(20));
        }
        if (products.isEmpty()) {
            System.out.println("-".repeat(20));
            System.out.println("Produk Kosong");
            System.out.println("-".repeat(20));
        }
    }

    @Override
    public void searchProduct(String name) {
        boolean Found = false;
        for (Product product : products) {
            if (product.getName().equals(name) || product.getBrand().equals(name)) {
                System.out.println("-".repeat(20));
                System.out.println("Id produk : " + product.getId());
                System.out.println("tanggal produk : " + product.getDate());
                System.out.println("Nama produk : " + product.getName());
                System.out.println("Brand produk : " + product.getBrand());
                System.out.println("Harga produk : " + product.getPrice());
                System.out.println("-".repeat(20));
                Found = true;
            }
        }
        if (!Found) {
            System.out.println("Produk Tidak Ditemukan");
        }

    }

}
