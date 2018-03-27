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
    public String toString() {
        return "Product [code=" + code + ", name=" + name + ", category="
                + category + ", quantity=" + quantity + "]";
    }


}
