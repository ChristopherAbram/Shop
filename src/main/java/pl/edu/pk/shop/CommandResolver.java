package pl.edu.pk.shop;

import pl.edu.pk.shop.command.*;
import pl.edu.pk.shop.command.modules.AdminModule;
import pl.edu.pk.shop.request.*;

public class CommandResolver {
	// vars {
	
	// } methods {
		// public {
			
			public CommandResolver(){
				
			}// end CommandResolver
			
			/**
			 **/
			public Command getCommand(Request request){
				// analiza ¿¹dania i zwrócenie odpowiedniego modu³u:
				// ...
				return new AdminModule();
			}
			
		// } protected {
			
			
			
		// } private {
			
		// }
	// }
}
