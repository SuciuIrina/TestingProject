package ui;





import controller.StoreController;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Vlad on 17-Mar-16.
 */
public class StoreUI {
    public StoreController ctrl;
    Scanner in;

    public StoreUI(StoreController ctrl) {
        this.ctrl = ctrl;
        this.in = new Scanner(System.in);
    }

    public void printMenu() {
        String menu;
        menu = "These are the available commands:\n";
        menu += "\t 1 - Add a new Product \n";
        menu += "\t 2 - Displays all products from category\n";
        menu += "\t 3 - Stock situation for all productst \n";
        menu += "\t 4 - Stock situation for a certain product \n";
        menu += "\t 0 - to exit; \n";
        System.out.println(menu);
    }

    public boolean isValid(String string){
        return string.matches("[a-zA-Z]+");
    }

    public void addNewProduct() {

        int pCode = 0;

        while (true) {
            try {
                System.out.println("Give the Product code:");
                pCode = Integer.parseInt(in.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Expected an integer. Try again!");
            }
        }
        String pName;
        while (true) {
            System.out.println("Give the product name:");
            String input=in.nextLine();
            if (isValid(input) ) {
                pName =input;
                break;
            } else {
                System.out.println("Invalid input. Expected a string.Try again!");
            }
        }


        String pCategory ;
        while (true) {
            System.out.println("Give the product category:");
            String input=in.nextLine();
            if (isValid(input) ) {
                pCategory =input;
                break;
            } else {
                System.out.println("Invalid input. Expected a string.Try again!");
            }
        }

        int pQunatity ;
        while (true) {
            try {
                System.out.println("Give the quantity:");
                pQunatity = Integer.parseInt(in.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Expected an integer. Try again!");
            }
        }

        Product p = new Product(pCode, pName, pCategory, pQunatity);
        System.out.println(p.toString());
        ctrl.addProduct(p);
        System.out.println("Product Added");
    }

    public void displayCategory() {
        System.out.println("Give category");
        String cat = in.nextLine();
        ArrayList<Product> temp = ctrl.getProductsCategory(cat);

        for (Product p : temp) {
            System.out.println(p.toString());
        }

        if(temp.size()==0){
            System.out.println("There are no products in this category.");
        }
    }

    public void displayStock() {

        ArrayList<Product> temp = ctrl.stockSituation();

        for (Product p : temp) {
            System.out.println(p.toString());
        }

        if(temp.size()==0){
            System.out.println("There are no products in the stock.");
        }
    }

    public void displayStockFor() {
        System.out.println("Give product name");
        String cat = in.nextLine();
        ArrayList<Product> temp = ctrl.stockSituationProduct(cat);

        for (Product p : temp) {
            System.out.println(p.toString());
        }

        if(temp.size()==0){
            System.out.println("There is no product with this name on the stock.");
        }
    }

    public int readCommand() {
        System.out.println("Give a command: ");
        int c = 0;
        c = Integer.parseInt(in.nextLine());
        return c;
    }

    public void executeCommand(int c) {
        switch (c) {
            case 1:
                addNewProduct();
                break;
            case 2:
                displayCategory();
                break;
            case 3:
                displayStock();
                break;
            case 4:
                displayStockFor();
                break;
            default:
                System.out.println("B'bye now!...\n");
                break;
        }
    }

    public void run() {
        int c;
        do {
            printMenu();
            c = readCommand();
            executeCommand(c);
        } while (c != 0);

    }


}
