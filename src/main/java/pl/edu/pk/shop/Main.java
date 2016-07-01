package pl.edu.pk.shop;

import java.util.*;

import pl.edu.pk.shop.database.Database;
import pl.edu.pk.shop.elements.tabledata.*;
import pl.edu.pk.shop.elements.address.*;
import pl.edu.pk.shop.elements.category.Category;
import pl.edu.pk.shop.elements.function.*;
import pl.edu.pk.shop.elements.item.Item;
import pl.edu.pk.shop.elements.item.ItemsList;
import pl.edu.pk.shop.elements.user.*;
import pl.edu.pk.shop.request.*;
import static pl.edu.pk.shop.staticfunctions.Functions.*;

import pl.edu.pk.shop.*;

public class Main {
	
	/**
	 * @author Christopher Abram
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Run shop application:
		try {
			ShopApplication.runShop();
		} catch(Exception e){
			println("Upsss!!! Unexpected error occurred...");
			println(e.getMessage());
		}
	}// end main
	
	static public void getName(Object[] v){
		for(Object x : v)
			System.out.println(x.getClass().getSimpleName());
		return;
	}

}
