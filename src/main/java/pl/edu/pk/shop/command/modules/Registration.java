package pl.edu.pk.shop.command.modules;

import static pl.edu.pk.shop.staticfunctions.Functions.*;

import java.util.Scanner;

import pl.edu.pk.shop.elements.address.Address;
import pl.edu.pk.shop.elements.address.AddressData;
import pl.edu.pk.shop.elements.function.Function;
import pl.edu.pk.shop.elements.user.UserData;
import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

public class Registration extends Module {
	// vars {
	
	// } methods {
		// public {
				
				
				
		// } protected {
				
			protected void _execute(Request request){
					
				UserData data = new UserData();
				Scanner s = new Scanner(System.in);
				
				data.id = getNextUserId();
				
				print("First name: ");
				String first_name = new String(s.nextLine().trim());
				data.first_name = first_name;
				
				print("Second name: ");
				String second_name = new String(s.nextLine().trim());
				data.second_name = second_name;
				
				// Function:
				data.function = new Function(2);
				
				// Address {
					AddressData a_data = new AddressData();
					a_data.id = getNextAddressId();
					
					print("Street: ");
					String street = new String(s.nextLine().trim());
					a_data.street = street;
					
					print("Flatnumber: ");
					String flat = new String(s.nextLine().trim());
					a_data.flatnumber = flat;
					
					print("City: ");
					String city = new String(s.nextLine().trim());
					a_data.cityname = city;
					
					print("Zip Code: ");
					String zip = new String(s.nextLine().trim());
					a_data.zipcode = zip;
					
					a_data.insert();
					data.address = new Address(a_data.id);
					
				// }
					
				print("e-mail: ");
				String email = new String(s.nextLine().trim());
				data.email = email;
				
				print("Phone number: ");
				String phone = new String(s.nextLine().trim());
				data.phonenumber = phone;
				
				print("Password: ");
				String password = new String(s.nextLine().trim());
				data.password = password;
				
				
				// Creating new user:
				data.insert();
				Session.getInstance().put(Request.MODULE, "Start");
				
				return;
			}
				
		// } private {
				
		// }
	// }
}
