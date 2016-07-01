package pl.edu.pk.shop.command.modules;

import static pl.edu.pk.shop.staticfunctions.Functions.getInt;
import static pl.edu.pk.shop.staticfunctions.Functions.mprintln;
import static pl.edu.pk.shop.staticfunctions.Functions.println;

import java.util.Scanner;

import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

public class AdminMenu extends Module {
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
					"2 |	Add Item",
					"3 |	Add Category",
					"4 |	Items",
					"5 |	History",
					"6 |	About Us",
					"7 | 	Logout",
					""
				);
				
				int position = 0;
				do {
					position = getInt("Podaj opcjê z menu: ", "Podaj opcjê z menu jeszcze raz: ", true);
					p = false;
					if(position < 1 || position > 7){
						println("Nie ma takiej opcji");
						p = true;
					}
				} while(p);
				
				switch(position){
					case 1:
						Session.getInstance().put(Request.MODULE, "UserStart");
						break;
					case 2:
						Session.getInstance().put(Request.MODULE, "AddItem");
						break;
					case 3:
						Session.getInstance().put(Request.MODULE, "AddCategory");
						break;
					case 4:
						Session.getInstance().put(Request.MODULE, "ViewBase");
						break;
					case 5:
						Session.getInstance().put(Request.MODULE, "History");
						break;
					case 6:
						Session.getInstance().put(Request.MODULE, "AboutUs");
						break;
					case 7:
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
