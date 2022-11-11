package models;

import configuration.factory.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Logger logger = LoggerFactory.getLogger(Cart.class);

    public List<Product> getProducts() {
        return products;
    }

    private List<Product> products;

    public double getTotalOrderCost() {
        return totalOrderCost;
    }

    private double totalOrderCost;

    public Cart() {
        this.products = new ArrayList<>();
        this.totalOrderCost = 0;
    }


    public void addProduct(Product newProduct) {
        logger.info("Current cart size: " + products.size());
        logger.info("Current total order cost: " + totalOrderCost);
        totalOrderCost = totalOrderCost + (newProduct.getQuantity() * getPrice(newProduct.getProductPrice()));
        logger.info("New total order cost: " + totalOrderCost);
        if (isProductAlreadyInCart(products, newProduct)) {
            for (Product product : products) {
                if (product.getProductName().equals(newProduct.getProductName())) {
                    logger.info("Old quantity:" + product.getQuantity() + " ___ " + "New quantity: " + newProduct.getQuantity());
                    product.setQuantity(product.getQuantity() + newProduct.getQuantity());
                    logger.info("New quantity: " + product.getQuantity());
                    logger.info("Increased quantity in cart, cart size: " + products.size());
                }
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
        }
        return false;
    }
    public Double getPrice(String price) {
        return Double.parseDouble(price.replace(System.getProperty("currency"), ""));
    }
}
