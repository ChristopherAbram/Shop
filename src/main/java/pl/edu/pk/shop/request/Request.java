package pl.edu.pk.shop.request;

import static pl.edu.pk.shop.staticfunctions.Functions.println;
import java.util.HashMap;

public abstract class Request {
	// vars {
		
		protected HashMap<String, String> _properties = new HashMap<String, String>();
	
	// } methods {
		// public {
			
			public void setProperty(String key, String value){
				this._properties.put(key, value);
				return;
			}
		
			public String getProperty(String key){
				if(this._properties.containsKey(key))
					return this._properties.get(key);
				return "";
			}
			
		// } protected {
			
		// } private {
			
		// }
	// }
}
