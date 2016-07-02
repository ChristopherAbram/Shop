package pl.edu.pk.shop.command.modules;

import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

public class Logout extends Module {
	// vars {
	
	// } methods {
		// public {
			
			
			
		// } protected {
			
			protected void _execute(Request request){
				
				Session s = Session.getInstance();
				
				s.put(Request.LOGGED, "0");
				s.put(Request.GUEST, "0");
				s.put(Request.ADMIN, "0");
				s.user = null;
				
				s.put(Request.MODULE, "Start");
				return;
			}
			
		// } private {
			
		// }
	// }
}
