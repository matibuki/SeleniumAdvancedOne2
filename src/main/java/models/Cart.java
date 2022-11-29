package models;

import org.openqa.selenium.devtools.v100.storage.model.InterestGroupAccessed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static final Logger logger = LoggerFactory.getLogger(Cart.class);

    public List<Product> getProducts() {
        return products;
    }

    private final List<Product> products;

    public BigDecimal getTotalOrderCost() {
        return totalOrderCost;
    }

private BigDecimal totalOrderCost;
    public Cart() {
        this.products = new ArrayList<>();
        this.totalOrderCost = BigDecimal.ZERO;
    }

    public void addProduct(Product newProduct) {
        logger.info("Current cart size: " + products.size());
        logger.info("Current total order cost: " + totalOrderCost);
        totalOrderCost = totalOrderCost.add(multiplyBigDecimal(newProduct.getProductQuantity(), getPrice(newProduct.getProductPrice())));
        logger.info("New total order cost: " + totalOrderCost);
        for (Product product : products) {
            if (product.getProductName().equals(newProduct.getProductName())) {
                logger.info("Old quantity:" + product.getProductQuantity() + " ___ " + "New quantity: " + newProduct.getProductQuantity());
                product.setQuantity(product.getProductQuantity() + newProduct.getProductQuantity());
                logger.info("New quantity: " + product.getProductQuantity());
                logger.info("Increased quantity in cart, cart size: " + products.size());
                return;
            }
        }
        products.add(newProduct);
        logger.info("Added product to cart, cart size: " + products.size());
    }

    public BigDecimal getPrice(String price) {
        return BigDecimal.valueOf((Double.parseDouble(price.replace(System.getProperty("currency"), ""))));
    }

    public BigDecimal multiplyBigDecimal(int quantity, BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
