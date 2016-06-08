<<<<<<< HEAD
package pl.edu.pk.shop;

import pl.edu.pk.shop.address.*;
import pl.edu.pk.shop.function.*;
import static pl.edu.pk.shop.staticfunctions.Functions.*;

public class Main {
	
	/**
	 * @author Christopher Abram
	 * @param args
	 */
	public static void main(String[] args) {
		
		Function f = new Function(3);
		mprintln(f.data.id, 
				f.data.function_name, 
				f.data.access_level);
		
		// Comments:
		// Creating new address:
		Address address = new Address(1);
		mprintln(address.data.id, 
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
		
		/*try {
			Database db = Database.getInstance();
			db.connect();
			
			db.query("SELECT id, itemname FROM item WHERE id > ? AND itemname NOT LIKE ? ORDER BY itemname ASC");
			db.prepare(5, "KITCHEN AMICA 58CE3.413HTaKDpQ ( Xx )");
			
			db.execute();
			Results r = db.getResults();
			while(r.hasNext()){
				Results.Row row = r.next();
				System.out.println(row.get("id") + "    " + row.get("itemname"));
			}
		} catch (DatabaseException dbe){
			System.out.println(dbe.getMessage()); 
		}*/
	}// end main
	
	static public void getName(Object[] v){
		for(Object x : v)
			System.out.println(x.getClass().getSimpleName());
		return;
	}

}
=======
package pl.edu.pk.shop;

import java.util.*;
import pl.edu.pk.shop.elements.tabledata.*;
import pl.edu.pk.shop.elements.address.*;
import pl.edu.pk.shop.elements.function.*;
import pl.edu.pk.shop.elements.user.*;
import static pl.edu.pk.shop.staticfunctions.Functions.*;

public class Main {
	
	/**
	 * @author Christopher Abram
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*Admin admin = new Admin(1);
		mprintln(admin.data.first_name, admin.data.second_name, "");
		*/
		
		Function f = new Function(3);
		mprintln(f.data.id, 
				f.data.function_name, 
				f.data.access_level);
		
		//Function g = new Function(f);
		
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
>>>>>>> dfb2282c4042e3ab322333be889b550b5ec39ef8
