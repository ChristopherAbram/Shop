package pl.edu.pk.shop;

import java.util.*;
import pl.edu.pk.shop.elements.tabledata.*;
import pl.edu.pk.shop.elements.address.*;
import pl.edu.pk.shop.elements.category.Category;
import pl.edu.pk.shop.elements.function.*;
import pl.edu.pk.shop.elements.item.Item;
import pl.edu.pk.shop.elements.item.ItemsList;
import pl.edu.pk.shop.elements.user.*;
import static pl.edu.pk.shop.staticfunctions.Functions.*;

public class Main {
	
	/**
	 * @author Christopher Abram
	 * @param args
	 */
	public static void main(String[] args) {
		
		Category root = new Category(1);
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
		
		
		
		
		
		/*Admin admin = new Admin(1);
		mprintln(admin.data.first_name, admin.data.second_name, "");
		*/
		
		/*Function f = new Function(3);
		mprintln(f.data.id, 
				f.data.function_name, 
				f.data.access_level);
		
		//Function g = new Function(f);
		
		// Comments:
		// Creating new address:
		Address address = new Address(1);
		mprintln(address.data.id, 
				address.data.street, 
				address.data.flatnumber, 
				address.data.cityname, 
				address.data.zipcode);
		
		Address address1 = address.clone();
		address1.data.street = "Jakas inna ulica...";
		address1.data.cityname = "Inna ulica";
		
		mprintln("", address1.data.id, 
				address1.data.street, 
				address1.data.flatnumber, 
				address1.data.cityname, 
				address1.data.zipcode);
		
		mprintln("",address.data.id, 
				address.data.street, 
				address.data.flatnumber, 
				address.data.cityname, 
				address.data.zipcode);
		
		/*address.data.delete();
		
		Address address1 = new Address(6);
		System.out.println(address1.data.id);
		System.out.println(address1.data.street);
		System.out.println(address1.data.flatnumber);
		System.out.println(address1.data.cityname);
		System.out.println(address1.data.zipcode);
		
		address.data.street = "Krakowska";
		address.data.update();
		
		System.out.println(address.data.id);
		System.out.println(address.data.street);
		System.out.println(address.data.flatnumber);
		System.out.println(address.data.cityname);
		System.out.println(address.data.zipcode);
		
		AddressData data = new AddressData();
		data.id = 6;
		data.street = "Bracka";
		data.flatnumber = "4/8";
		data.cityname = "Kraków";
		data.zipcode = "10-345";
		data.insert();*/
		
		
	}// end main
	
	static public void getName(Object[] v){
		for(Object x : v)
			System.out.println(x.getClass().getSimpleName());
		return;
	}

}
