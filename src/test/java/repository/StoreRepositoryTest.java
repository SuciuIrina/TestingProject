package repository;

import model.Product;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by dell on 3/27/2018.
 */
public class StoreRepositoryTest {

    private StoreRepository repository;

    public StoreRepositoryTest() throws IOException {
        repository=new StoreRepository("products.txt");
    }

    @Test
    public void addNewProduct1() {
        Product product=new Product(3,"portocale","fructe",89);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addNewProduct2() {
        Product product=new Product(-100,"portocale","fructe",-67);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addProductValidQuantity(){
        Product product=new Product(4,"cirese","fructe",10);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addProductInvalidQuantity1(){
        Product product=new Product(5,"cirese","fructe",-10);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addProductInvalidQuantity2(){
        String quantity="100000000000000000";
        try {
            int q = Integer.parseInt(quantity);
            Product product=new Product(6,"cirese","fructe",q);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addProductValidCode(){
        Product product=new Product(7,"pere","fructe",10);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addProductInvalidCode1(){
        Product product=new Product(-1,"pere","fructe",10);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addProductInvalidCode2(){
        String code="100000000000000000";
        try {
            int c = Integer.parseInt(code);
            Product product=new Product(c,"pere","fructe",10);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addProductUniqueCode(){
        Product product=new Product(99,"mere","fructe",10);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addProductDuplicateCode(){
        Product product=new Product(repository.getAllProducts().get(0).getCode(),"mere","fructe",10);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void addProductValidName(){
        Product product=new Product(8,"ananas","fructe",10);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void addProductInvalidName(){
        Product product=new Product(9,"ananas*","fructe",10);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void addProductValidCategory(){
        Product product=new Product(10,"banane","fructe",10);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void addProductInvalidCategory(){
        Product product=new Product(11,"banane","fruc&te",10);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}