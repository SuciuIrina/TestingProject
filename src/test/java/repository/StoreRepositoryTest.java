package repository;

import model.Product;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by dell on 3/27/2018.
 */
public class StoreRepositoryTest {

    private StoreRepository repository=new StoreRepository();

    @Test
    public void addNewProduct1() {
        Product product=new Product(100,"ananas","fructe",89);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addNewProduct2() {
        Product product=new Product(-100,"ananas","fructe",-67);
        try {
            assertTrue(repository.addNewProduct(product));
        } catch (Exception e) {
            assertTrue(false);
        }

    }


}