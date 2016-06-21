package pl.edu.pk.shop.request;

import static pl.edu.pk.shop.staticfunctions.Functions.println;
import pl.edu.pk.shop.session.*;

public class ModuleRequest extends Request {
	// vars {
		
		private Session __session = null;
	
	// } methods {
		// public {
			
			public ModuleRequest(){
				__session = Session.getInstance();
				
				println(__session.toString());
				
				if(__session.isEmpty() && !__session.containsKey(Request.LOGGED)){
					this.setProperty(Request.MODULE, "Start");
				}
				
				if(this.__session.containsKey(Request.MODULE)){
					
					/* BASIC */
					if(__session.get(Request.MODULE).equals("Registration"))
						this.setProperty(Request.MODULE, "Registration");
					
					else if(__session.get(Request.MODULE).equals("Login"))
						this.setProperty(Request.MODULE, "Login");
					
					else if(__session.get(Request.MODULE).equals("Logout"))
						this.setProperty(Request.MODULE, "Logout");
					
					
					/* GUEST */
					if(__session.containsKey(Request.GUEST) && __session.get(Request.GUEST).equals("1")){
						if(__session.get(Request.MODULE).equals("GuestMenu"))
							this.setProperty(Request.MODULE, "GuestMenu");
						
						else if(__session.get(Request.MODULE).equals("ViewBase"))
							this.setProperty(Request.MODULE, "ViewBase");
					}
					
					
					
					
					/* Logged USER */
					if(__session.containsKey(Request.LOGGED) && __session.get(Request.LOGGED).equals("1")){
						
						if(__session.get(Request.MODULE).equals("UserStart"))
							this.setProperty(Request.MODULE, "UserStart");
							
						else if(__session.get(Request.MODULE).equals("UserMenu"))
							this.setProperty(Request.MODULE, "UserMenu");
						
						else if(__session.get(Request.MODULE).equals("ViewBase"))
							this.setProperty(Request.MODULE, "ViewBase");
					}
				}
			}
	
		// } protected {
			
		// } private {
			
		// }
	// }
}