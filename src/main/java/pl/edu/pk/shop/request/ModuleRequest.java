package pl.edu.pk.shop.request;

import static pl.edu.pk.shop.staticfunctions.Functions.println;

public class ModuleRequest extends Request {
	// vars {
	
	// } methods {
		// public {
			
			public ModuleRequest(String... strings){
				if(strings.length % 2 == 0)
					for(int i = 0; i < strings.length; i+=2)
						this._properties.put(strings[i], strings[i + 1]);
			}
	
		// } protected {
			
		// } private {
			
		// }
	// }
}