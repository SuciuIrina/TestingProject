package controller;




import model.Product;
import repository.StoreRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StoreController { 
	StoreRepository io;

	public StoreController(String fileName) throws IOException {
		io=new StoreRepository(fileName);
	}
	public void readProducts(String f){
		try {
			io.readFile(f);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void addProduct(Product p){
		try {
            BufferedWriter out = new BufferedWriter(new FileWriter("products.txt", true));
			if(io.addNewProduct(p)){
                out.newLine();
                out.write(p.getCode() + " " + p.getName() + " " + p.getCategory() + " " + p.getQuantity());
                out.close();
            }else{
			    out.close();
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public ArrayList<Product> getProductsCategory(String cat){
		return io.getProductsCategory(cat);
	}
	
	public ArrayList<Product> stockSituationProduct(String pname){
		return io.stockSituationProduct(pname);
	}
	public ArrayList<Product> stockSituation(){
		return io.stockSituation();
	}
}
