package pl.edu.pk.shop;

public class ShopApplication implements Controller {
	// vars {
	
		
	
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
				init();
				handleRequest();
				return;
			}// end run
	
			/** 
			 **/
			public void init(){
				
				return;
			}// end init
			
			/** 
			 **/
			public void handleRequest(){
				
				return;
			}// end handleRequest
			
		// } protected {
			
		// } private {
			
			private ShopApplication(){}
	
		// }
	// }
}
