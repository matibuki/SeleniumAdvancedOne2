package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    BigDecimal totalOrderCost;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        totalOrderCost = getTotalOrderCost();
        if ((products.size()) == 0) {
            products.add(product);
            totalOrderCost = getTotalOrderCost();
        } else {
            addProductToCart();
            totalOrderCost = getTotalOrderCost();
        }

//        return new Product()
    }
}

