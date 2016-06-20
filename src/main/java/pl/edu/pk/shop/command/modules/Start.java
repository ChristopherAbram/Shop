package pl.edu.pk.shop.command.modules;

import pl.edu.pk.shop.request.Request;
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
					" Aby sie zalogowac wpisz swoj login i haslo",
					" Aby skorzystaæ z aplikacji jako gosc, wpisz jako login: guest (nie wymaga hasla)",
					"___________________________________________________________________________________"
				);
				
				// 
				
				
				return;
			}
			
		// } private {
			
		// }
	// }
}