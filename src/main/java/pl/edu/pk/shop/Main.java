package pl.edu.pk.shop;

import pl.edu.pk.shop.tabledata.*;
import pl.edu.pk.shop.address.*;
import pl.edu.pk.shop.function.*;
import pl.edu.pk.shop.user.*;
import static pl.edu.pk.shop.staticfunctions.Functions.*;

public class Main {
	
	/**
	 * @author Christopher Abram
	 * @param args
	 */
	public static void main(String[] args) {
		
		Admin admin = new Admin(1);
		mprintln(admin.data.first_name, "");
		
		
		Function f = new Function(3);
		mprintln(f.data.id, 
				f.data.function_name, 
				f.data.access_level);
		
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
