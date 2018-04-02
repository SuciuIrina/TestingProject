import ui.StoreUI;

import java.io.IOException;

/**
 * Created by dell on 4/2/2018.
 */
public class App {
    public static void main(String[] args) throws IOException {
        try {
            StoreUI u = new StoreUI("products.txt");
            u.run();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
