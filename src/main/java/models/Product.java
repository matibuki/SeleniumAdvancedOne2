package models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Product {
    private static final Logger logger = LoggerFactory.getLogger(Product.class);
    private String productName;
    private String productPrice;
    private int quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String productName, String productPrice, int quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        logger.info("New product created: " + productName + "-" + productPrice + "-q:" + quantity);
    }
}
