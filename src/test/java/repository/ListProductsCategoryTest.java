package repository;

import model.Product;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by dell on 4/3/2018.
 */
public class ListProductsCategoryTest {

    private StoreRepository repo;

    public ListProductsCategoryTest() throws IOException {
        this.repo = new StoreRepository("products.txt");
    }

    @Test
    public void getProductsFromCategory(){
        String category="fructe";
        ArrayList<Product> result=new ArrayList<Product>();
        result=repo.getProductsCategory(category);

        assertEquals(1,result.size());
    }

    @Test
    public void getProductsFromCategory2(){
        String category="categorie";
        ArrayList<Product> result=new ArrayList<Product>();
        result=repo.getProductsCategory(category);

        assertEquals(0,result.size());
    }

    @Test
    public void getProductsFromCategory3(){
        String category="aliment";
        ArrayList<Product> result=new ArrayList<Product>();
        result=repo.getProductsCategory(category);

        assertEquals(1,result.size());
        assertEquals(new Product(1,"paine","aliment",100),result.get(0));
    }

    @Test
    public void getProductsFromCategory4(){
        String category="dulciuri";
        ArrayList<Product> result=new ArrayList<Product>();
        result=repo.getProductsCategory(category);

        assertEquals(0,result.size());
    }

    @Test
    public void getProductsFromCategory5(){
        this.repo.setAllProducts(new ArrayList<Product>());
        String category="fructe";
        ArrayList<Product> result=new ArrayList<Product>();
        result=repo.getProductsCategory(category);

        assertEquals(0,result.size());
    }
}
