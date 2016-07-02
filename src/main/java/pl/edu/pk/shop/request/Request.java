package pl.edu.pk.shop.request;

import java.util.HashMap;

public abstract class Request {
	// vars {
		
		protected HashMap<String, String> _properties = new HashMap<String, String>();
		
		// Defined attributes:
		public final static String MODULE = "module";
		public final static String LOGGED = "logged";
		public final static String GUEST = "guest";
		public final static String ADMIN = "admin";
		
		
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
			
			public boolean hasProperty(String key){
				return this._properties.containsKey(key);
			}
			
		// } protected {
			
		// } private {
			
		// }
	// }
}
