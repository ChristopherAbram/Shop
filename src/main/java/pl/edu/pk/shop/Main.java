package pl.edu.pk.shop;

import java.util.*;
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
		//ShopApplication.runShop();
		
		
		/*Category root = new Category(1);
		root.initTree(); // loads subcategories
		
		mprintln(root.data.categoryname, root.data.catdescription, "Przedmioty:");
		
		if(root.loadItems()){
			ItemsList l = root.getItems();
			ListIterator<Item> iter = l.listIterator();
			while(iter.hasNext()){
				Item item = iter.next();
				println(item.data.itdescription);
			}
		} else
			println("Unable to load items.");
		*/
		
	}// end main
	
	static public void getName(Object[] v){
		for(Object x : v)
			System.out.println(x.getClass().getSimpleName());
		return;
	}

}
