package com.enigma.gosling.Service;

import com.enigma.gosling.Product;


public interface ProductService {

    void addProduct(Product product);

    void deleteProduct(int id);

    void updateProduct(int idproduct, Product product);

    void viewProduct();

    void searchProduct(String name);
}
