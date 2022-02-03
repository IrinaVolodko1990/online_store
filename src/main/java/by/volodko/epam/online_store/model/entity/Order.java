package by.volodko.epam.online_store.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
    private long orderId;
    private long customerId;
    private LocalDate date;
    private OrderStatus status;
    private PaymentType paymentType;
    private Address address;
    private BigDecimal price;
    private String comment;

    public Order() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (customerId != order.customerId) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (status != order.status) return false;
        if (paymentType != order.paymentType) return false;
        if (address != null ? !address.equals(order.address) : order.address != null) return false;
        if (price != null ? !price.equals(order.price) : order.price != null) return false;
        return comment != null ? comment.equals(order.comment) : order.comment == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderId=").append(orderId);
        sb.append(", customerId=").append(customerId);
        sb.append(", date=").append(date);
        sb.append(", status=").append(status);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", address=").append(address);
        sb.append(", price=").append(price);
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class OrderBuilder {
        private Order order;

        public OrderBuilder(Order order) {
            order = new Order();
        }

        public Order build() {
            return order;
        }

        public OrderBuilder setOrderId(long orderId) {
            order.orderId = orderId;
            return this;
        }

        public OrderBuilder setCustomerId(long customerId) {
            order.customerId = customerId;
            return this;

        }

        public OrderBuilder setDate(LocalDate date) {
            order.date = date;
            return this;
        }

        public OrderBuilder setStatus(OrderStatus status) {
            order.status = status;
            return this;
        }

        public OrderBuilder setPaymentType(PaymentType paymentType) {
            order.paymentType = paymentType;
            return this;
        }

        public OrderBuilder setAddress(Address address) {
            order.address = address;
            return this;
        }

        public OrderBuilder setPrice(BigDecimal price) {
            order.price = price;
            return this;
        }


    }
}
