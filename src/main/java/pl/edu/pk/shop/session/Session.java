package pl.edu.pk.shop.session;

import java.util.*;
import pl.edu.pk.shop.elements.user.User;

@SuppressWarnings("serial")
public class Session extends HashMap<String, String> {
	// vars {
	
		protected static  Session _session = null;
		
		public User user = null;
	
	// } methods {
		// public {
			
			public static Session getInstance(){
				if(_session == null)
					_session = new Session();
				return _session;
			}
			
			public String toString(){
				String str = "";
				
				Collection<String> keys = this.keySet();
				Iterator<String> iter = keys.iterator();
				while(iter.hasNext()){
					String key = iter.next();
					str += "key: " + key + ", value: " + this.get(key) + "\n";
				}
				return str;
			}
	
		// } protected {
			
			
			
		// } private {
			
			private Session(){}
	
		// }
	// }
}
