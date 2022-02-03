package by.volodko.epam.online_store.model.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class OrderBasket {
    private long orderId;
    private Map<Product, Integer> productsList;
    private BigDecimal summaryPrice;

    public OrderBasket() {
        productsList = new HashMap<>();
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    public Map<Product, Integer> getProductsList() {
        return productsList;
    }

    public void setProductsList(Map<Product, Integer> productsList) {
        this.productsList = productsList;
    }

    public void addProduct(Product product, int quantity) {
        if (productsList.containsKey(product)) {
            int number = productsList.get(product);
            productsList.put(product, number + quantity);
        } else {
            productsList.put(product, quantity);
        }
    }

    public void reduceProductNumbers(Product product, int quantity) {
        if (productsList.containsKey(product)) {
            int number = productsList.get(product);
            if (number > quantity) {
                productsList.put(product, number - quantity);
            } else {
                productsList.remove(product);
            }
        }
    }


    public void deleteProduct(Product product) {
        productsList.remove(product);
    }

    public void clearProductsList() {
        productsList.clear();
    }


    public BigDecimal getSummaryPrice() {
        summaryPrice = new BigDecimal(0);
        productsList.forEach((k, v) -> summaryPrice.add(k.getPrice().multiply(new BigDecimal(v))));
        return summaryPrice;
    }


}
