package pl.edu.pk.shop.command.modules;

import java.util.Scanner;

import pl.edu.pk.shop.elements.user.User;
import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;
import static pl.edu.pk.shop.staticfunctions.Functions.*;

public class UserStart extends Module {
	// vars {
	
	// } methods {
		// public {
			
			
			
		// } protected {
			
			protected void _execute(Request request){
				User user = Session.getInstance().user;
				
				mprintln(
					"", "Start",
					"__________________________________________________________________________",
					"Witaj " + user.data.first_name + " " + user.data.second_name + "!!!",
					"", "",
					"Twoje dane:",
					"Imie: " + user.data.first_name,
					"Nazwisko:" + user.data.second_name,
					"e-mail: " + user.data.email,
					"tel: " + user.data.phonenumber,
					"", "",
					"Dane adresowe:",
					"Miescowosc: " + user.data.address.data.cityname,
					"Kod pocztowy: " + user.data.address.data.zipcode,
					"Ulica: " + user.data.address.data.street,
					"Numer mieszkania: " + user.data.address.data.flatnumber,
					"", ""
				);
				
				Scanner s = new Scanner(System.in);
				print("Nacisnij enter, by przejsc do menu. ");
				if(s.hasNextLine())
					s.nextLine();
				
				
				Session.getInstance().put(Request.MODULE, "Menu");
			}
			
		// } private {
			
		// }
	// }
}
