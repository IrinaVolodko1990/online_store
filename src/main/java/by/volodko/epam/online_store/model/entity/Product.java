package by.volodko.epam.online_store.model.entity;


import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Base64;

public class Product {
    private long productId;
    private String productName;
    private String brand;
    private String description;
    private BigDecimal price;
    private ProductCategory productCategory;
    private InputStream image;
    private int numberInStock;

    public Product() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return numberInStock > 0 ? true : false;
    }


    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public String getImageCode() {
        String imageCode = "";
        try {
            imageCode = Base64.getEncoder().encodeToString(image.readAllBytes());
        } catch (IOException e) {
        }
        return imageCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (numberInStock != product.numberInStock) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (productCategory != product.productCategory) return false;
        return image != null ? image.equals(product.image) : product.image == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (productId ^ (productId >>> 32));
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (productCategory != null ? productCategory.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + numberInStock;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("productId=").append(productId);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price);
        sb.append(", productCategory=").append(productCategory);
        sb.append(", image=").append(image);
        sb.append(", numberInStock=").append(numberInStock);
        sb.append('}');
        return sb.toString();
    }

    public static class ProductBuilder {
        private Product product;

        public ProductBuilder() {
            product = new Product();
        }

        public ProductBuilder setProductId(long productId) {
            product.setProductId(productId);
            return this;
        }


        public ProductBuilder setProductName(String productName) {
            product.setProductName(productName);
            return this;
        }

        public ProductBuilder setBrand(String brand) {
            product.setBrand(brand);
            return this;
        }

        public ProductBuilder setDescription(String description) {
            product.setDescription(description);
            return this;
        }

        public ProductBuilder setPrice(BigDecimal price) {
            product.setPrice(price);
            return this;
        }


        public ProductBuilder setProductCategory(ProductCategory productCategory) {
            product.setProductCategory(productCategory);
            return this;
        }

        public ProductBuilder setImage(InputStream inputStream) {
            product.setImage(inputStream);
            return this;
        }

        public ProductBuilder setNumberInStock(int numberInStock) {
            product.setNumberInStock(numberInStock);
            return this;
        }

        public Product build() {
            return product;
        }


    }

}

