package repository;

import model.Product;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by dell on 4/25/2018.
 */
public class Lab3Test {
    private StoreRepository repository;

    public Lab3Test() throws IOException {
        repository=new StoreRepository("products.txt");
    }

    @Test
    public void getAllProductsBBT(){
        ArrayList<Product> arrayList=new ArrayList<Product>();
        arrayList=repository.getAllProducts();
        assertTrue(arrayList.size()>0);
    }

    @Test
    public void addNewProduct() {
        Product product=new Product(3,"portocale","fructe",89);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getProductsFromCategory(){
        String category="fructe";
        ArrayList<Product> result=new ArrayList<Product>();
        result=repository.getProductsCategory(category);

        assertTrue(result.size()>=1);
    }


    @Test
    public void bigBangIntegration(){
        this.addNewProduct();
        this.getProductsFromCategory();
        this.getAllProductsBBT();

        ArrayList<Product> arrayList=new ArrayList<Product>();
        arrayList=repository.getProductsCategory("fructe");
        assertEquals(2,arrayList.size());
    }
}
