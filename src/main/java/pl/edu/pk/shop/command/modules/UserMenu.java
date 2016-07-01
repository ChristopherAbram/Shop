package pl.edu.pk.shop.command.modules;

import java.util.Scanner;

import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;
import static pl.edu.pk.shop.staticfunctions.Functions.*;

public class UserMenu extends Module {
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
					"1 | 	Start",
					"2 | 	Items",
					"3 | 	History",
					"4 |	About Us",
					"5 | 	Logout",
					""
				);
				
				int position = 0;
				do {
					position = getInt("Podaj opcjê z menu: ", "Podaj opcjê z menu jeszcze raz: ", true);
					p = false;
					if(position < 1 || position > 5){
						println("Nie ma takiej opcji");
						p = true;
					}
				} while(p);
				
				switch(position){
					case 1:
						Session.getInstance().put(Request.MODULE, "UserStart");
						break;
					case 2:
						Session.getInstance().put(Request.MODULE, "ViewBase");
						break;
					case 3:
						Session.getInstance().put(Request.MODULE, "History");
						break;
					case 4:
						Session.getInstance().put(Request.MODULE, "AboutUs");
						break;
					case 5:
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