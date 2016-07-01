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
				
				mprintln(
					"",
					"Moduly:",
					"__________________________________________________________________________",
					"1 | 	Items,",
					"2 | 	Sign in",
					"3 | 	Logout",
					""
				);
				
				print("Podaj opcjê z menu: ");
				int position = s.nextInt();
				
				switch(position){
					case 1:
						Session.getInstance().put(Request.MODULE, "ViewBase");
						break;
					case 2:
						Session.getInstance().put(Request.MODULE, "Registration");
						break;
					case 3:
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