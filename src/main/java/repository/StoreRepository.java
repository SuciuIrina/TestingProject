package repository;



import model.Product;

import java.io.*;
import java.util.ArrayList;


public class StoreRepository {
    private ArrayList<Product> allProducts = new ArrayList<Product>();

    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }

    public void readFile(String fname) throws NumberFormatException, IOException {
        FileInputStream f = new FileInputStream(fname);
        DataInputStream in = new DataInputStream(f);
        BufferedReader buf = new BufferedReader(new InputStreamReader(in));
        String rd;
        String[] line;
        while ((rd = buf.readLine()) != null) {
            line = rd.split(" ");
            this.allProducts.add(new Product(Integer.parseInt(line[0]), line[1], line[2], Integer.parseInt(line[3])));
        }
        in.close();
    }

    public boolean addNewProduct(Product p) throws Exception {
        if (p.getCode() > 0 && p.getQuantity() >= 0 && p.getCode() < Integer.MAX_VALUE && p.getQuantity() < Integer.MAX_VALUE ) {
            BufferedWriter out = new BufferedWriter(new FileWriter("products.txt", true));
            int k = 1;
            for (Product i : allProducts) {
                if (i.getCode() == p.getCode()) {
                    k = 0;
                }
            }
            if (k == 1) {
                out.newLine();
                out.write(p.getCode() + " " + p.getName() + " " + p.getCategory() + " " + p.getQuantity());
                out.close();
                allProducts.add(p);
            } else {
                out.close();
                throw new Exception("This code already exists.");
            }
        } else {
            throw new Exception("The quantity or the code is not in the range [0,2147483647]");
        }
        return true;
    }


    public ArrayList<Product> getProductsCategory(String cat) {
        ArrayList<Product> cProducts = new ArrayList<Product>();
        for (Product p : allProducts) {
            if (p.getCategory().compareTo(cat) == 0) {
                cProducts.add(p);
            }
        }
        return cProducts;
    }

    public ArrayList<Product> stockSituationProduct(String pname) {
        ArrayList<Product> prods = new ArrayList<Product>();
        for (Product p : allProducts)
            if (p.getName().compareTo(pname) == 0)
                prods.add(p);
        return prods;
    }

    public ArrayList<Product> stockSituation() {
        return allProducts;
    }

}
