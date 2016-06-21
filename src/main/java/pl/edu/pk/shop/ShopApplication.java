package pl.edu.pk.shop;

import pl.edu.pk.shop.command.Command;
import pl.edu.pk.shop.request.*;

public class ShopApplication implements Controller {
	// vars {
	
		private ApplicationHelper __ah;
	
	// } methods {
		// public {
			
			/** 
			 **/
			public static void runShop(){
				Controller sa = new ShopApplication();
				sa.run();
			}// end runShop
	
			/** 
			 **/
			public void run(){
				this.init();
				while(true){
				    // Handle Request:
					this.handleRequest();
				}
			}// end run
	
			/** 
			 **/
			public void init(){
				// Initializing application:
				__ah = ApplicationHelper.getInstance();
				__ah.init();
				return;
			}// end init
			
			/** 
			 **/
			public void handleRequest(){
				// Creating and initializing a request:
				Request request = new ModuleRequest();
				
				// Creating new CommandResolver for analyzing request:
				CommandResolver cmd_resolver = new CommandResolver();
				Command cmd = cmd_resolver.getCommand(request);
				
				// Executing appropriate module:
				cmd.execute(request);
				
				return;
			}// end handleRequest
			
		// } protected {
			
		// } private {
			
			private ShopApplication(){}
	
		// }
	// }
}
