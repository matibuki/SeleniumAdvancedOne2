package models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Logger logger = LoggerFactory.getLogger(Cart.class);

    public List<Product> getProducts() {
        return products;
    }

    private List<Product> products;
    double totalOrderCost; ////////// todo
///////////

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product newProduct) {
        logger.info("Current cart size: " + products.size());
//        totalOrderCost = getTotalOrderCost();
//        if ((products.contains(newProduct))) {
        if (isProductAlreadyInCart(products, newProduct)) {
            for (Product product : products) {
                if (product.getProductName().equals(newProduct.getProductName())) {
                    logger.info("Old quantity:" + product.getQuantity() + "___" + "New quantity: " + newProduct.getQuantity());
                    product.setQuantity(product.getQuantity() + newProduct.getQuantity());
                    logger.info("Probably new quantity: " + product.getQuantity());

                }
//            products.add(newProduct);
                logger.info("Increased quantity in cart, cart size: " + products.size());
                logger.info("Again new quantity?" + newProduct.getQuantity());
//            totalOrderCost = getTotalOrderCost();
            }
        } else {
            products.add(newProduct);
            logger.info("Added product to cart, cart size: " + products.size());
        }
//            totalOrderCost = totalOrderCost
    }

    public boolean isProductAlreadyInCart(List<Product> list, Product product) {
        for (Product prod : list) {
            if (prod.getProductName().equals(product.getProductName())) {
                return true;
            }
            return false;
        }
        return false;
    }
}