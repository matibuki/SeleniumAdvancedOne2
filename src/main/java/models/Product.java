package models;

public class Product {
    private String productName;
    private String productPrice;
    private String quantity;

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Product(String productName, String productPrice, String quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }
//    @Override
//    public String toString() {
//        return ("Product name: " + productName + " price: " + productPrice + " quantity: " + quantity);
//    }
}
