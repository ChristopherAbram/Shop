package pl.edu.pk.shop.command.modules;

import static pl.edu.pk.shop.staticfunctions.Functions.getStringLimited;
import static pl.edu.pk.shop.staticfunctions.Functions.mprintln;
import static pl.edu.pk.shop.staticfunctions.Functions.setWidth;

import java.util.Scanner;

import pl.edu.pk.shop.elements.address.Address;
import pl.edu.pk.shop.elements.address.AddressData;
import pl.edu.pk.shop.elements.function.Function;
import pl.edu.pk.shop.elements.user.UserData;
import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

public class NewAdmin extends Module {
	// vars {
		
	// } methods {
		// public {
			
		// } protected {
				
			protected void _execute(Request request){
				
				Scanner s = new Scanner(System.in);
				int width = 25;
				boolean p = false;
				
				mprintln("",
					" Rejestracja konta administratora",
					"___________________________________________________________________________________",
					"",""
				);
				
				UserData data = new UserData();
				
				String first_name = getStringLimited(setWidth("First name:", width), "First name incorrect, enter again: ", 3, 20, true);
				data.first_name = first_name;
				
				String second_name = getStringLimited(setWidth("Second name:", width), "Second name incorrect, enter again: ", 3, 35, true);
				data.second_name = second_name;
				
				// Address {
					AddressData a_data = new AddressData();
					
					String street = getStringLimited(setWidth("Street:", width), "Street incorrect, enter again: ", 3, 30, true);//new String(s.nextLine().trim());
					a_data.street = street;
					
					String flat = getStringLimited(setWidth("Flatnumber:", width), "Flatnumber incorrect, enter again: ", 1, 15, true);//new String(s.nextLine().trim());
					a_data.flatnumber = flat;
					
					String city = getStringLimited(setWidth("City:", width), "City incorrect, enter again: ", 3, 30, true);//new String(s.nextLine().trim());
					a_data.cityname = city;
					
					String zip = getStringLimited(setWidth("Zip Code:", width), "Zip Code incorrect, enter again: ", 3, 6, true);
					a_data.zipcode = zip;
					
					if(a_data.insert()){
						p = true;
						data.address = new Address(a_data.id);
					}
					else
						mprintln("","Nast¹pi³ b³¹d w trakcie zapisywania adresu", "");
					
				// }
				
				if(p){
					String email = getStringLimited(setWidth("e-mail:", width), "e-mail incorrect, enter again: ", 5, 64, true);
					data.email = email;
					
					String phone = getStringLimited(setWidth("Phone number:", width), "Phone number incorrect, enter again: ", 8, 15, true);
					data.phonenumber = phone;
					
					String password = getStringLimited(setWidth("Password:", width), "Password number incorrect, enter again: ", 4, 15, true);
					data.password = password;
					
					// Function:
					data.function = new Function(3);
				}
				
				// Creating new user:
				p &= data.insert();
				if(p)
					mprintln("","Poprawnie zarejestrowano u¿ytkownika","");
				else
					mprintln("","Nast¹pi³ b³¹d w trakcie rejestrowania nowego u¿ytkownika, spróbuj ponownie póŸniej...","");
				
				mprintln("","Naciœnij enter, aby przejœæ do start ");
				if(s.hasNextLine())
					s.nextLine();
				
				Session.getInstance().put(Request.MODULE, "Menu");
				
				return;
			}
				
		// } private {
				
		// }
	// }
}
