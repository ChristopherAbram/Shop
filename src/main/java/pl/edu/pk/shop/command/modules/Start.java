package pl.edu.pk.shop.command.modules;

import java.util.Scanner;

import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;
import static pl.edu.pk.shop.staticfunctions.Functions.*;

public class Start extends Module {
	// vars {
	
	// } methods {
		// public {
			
			
			
		// } protected {
			
			protected void _execute(Request request){
				
				// Ekran powitalny:
				mprintln(
					" Witaj w sklepie!!!",
					" Aby sie zalogowac wpisz 1",
					" Aby siê zarejestrowac wpisz 0",
					"___________________________________________________________________________________",
					""
				);
				
				Scanner s = new Scanner(System.in);
				
				// Enter option:
				int option = -1;
				do {
					option = getInt("Option: ", "Option again: ", true);
					
					if(!(option == 1 || option == 0))
						println("Nie ma takiej opcji...");
					
				} while (!(option == 1 || option == 0));
				
				//s.close();
				
				if(option == 0)
					Session.getInstance().put(Request.MODULE, "Registration");
				else if(option == 1)
					Session.getInstance().put(Request.MODULE, "Login");
				else {
					println("Error");
					this._execute(request);
				}
				return;
			}
			
		// } private {
			
		// }
	// }
}