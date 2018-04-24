package model;

public class Product {
    private int code = 0;
    private String name = null;
    private String category = null;
    private int quantity = 0;

    public Product(int code, String name, String category, int quantity) {
        super();
        this.code = code;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public Product() {
        // TODO Auto-generated constructor stub
    }

    public int getCode() {
        return code;
    }


    public String getName() {
        return name;
    }


    public String getCategory() {
        return category;
    }


    public int getQuantity() {
        return quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (code != product.code) return false;
        if (quantity != product.quantity) return false;
        if (!name.equals(product.name)) return false;
        return category.equals(product.category);
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + name.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "Product [code=" + code + ", name=" + name + ", category="
                + category + ", quantity=" + quantity + "]";
    }


}
