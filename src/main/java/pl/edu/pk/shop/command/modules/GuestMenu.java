package pl.edu.pk.shop.command.modules;

import java.util.Scanner;

import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;
import static pl.edu.pk.shop.staticfunctions.Functions.*;

public class GuestMenu extends Module {
	// vars {
	
	// } methods {
		// public {
			
			
			
		// } protected {
			
			protected void _execute(Request request){
				
				Scanner s = new Scanner(System.in);
				boolean p = false;
				mprintln(
					"",
					"Moduly:",
					"__________________________________________________________________________",
					"1 | 	Items",
					"2 | 	Sign in",
					"3 |	About Us",
					"4 | 	Logout",
					""
				);
				int position = 0;
				do {
					position = getInt("Podaj opcj� z menu: ", "Podaj opcj� z menu jeszcze raz: ", true);
					p = false;
					if(position < 1 || position > 4){
						println("Nie ma takiej opcji");
						p = true;
					}
				} while(p);
				
				switch(position){
					case 1:
						Session.getInstance().put(Request.MODULE, "GuestViewBase");
						break;
					case 2:
						Session.getInstance().put(Request.MODULE, "Registration");
						break;
					case 3:
						Session.getInstance().put(Request.MODULE, "AboutUs");
						break;
					case 4:
						Session.getInstance().put(Request.MODULE, "Logout");
						break;
					default:
						this._execute(request);
				}
			}
			
		// } private {
			
		// }
	// }
}