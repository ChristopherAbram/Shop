package pl.edu.pk.shop.request;

import static pl.edu.pk.shop.staticfunctions.Functions.*;
import pl.edu.pk.shop.session.*;

public class ModuleRequest extends Request {
	// vars {
		
		private Session __session = null;
	
	// } methods {
		// public {
			
			public ModuleRequest(){
				__session = Session.getInstance();
				
				//println(__session.toString());
				
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
					
					else if(__session.get(Request.MODULE).equals("AboutUs"))
						this.setProperty(Request.MODULE, "AboutUs");
					
					
					
					/* GUEST */
					if(__session.containsKey(Request.GUEST) && __session.get(Request.GUEST).equals("1")){
						if(__session.get(Request.MODULE).equals("Menu"))
							this.setProperty(Request.MODULE, "GuestMenu");
						
						else if(__session.get(Request.MODULE).equals("GuestViewBase"))
							this.setProperty(Request.MODULE, "GuestViewBase");
					}
					
					
					
					/* Logged USER */
					if(__session.containsKey(Request.LOGGED) && __session.get(Request.LOGGED).equals("1")){
						
						if(__session.get(Request.MODULE).equals("UserStart"))
							this.setProperty(Request.MODULE, "UserStart");
						
						else if(__session.get(Request.MODULE).equals("ViewBase"))
							this.setProperty(Request.MODULE, "ViewBase");
						
						else if(__session.get(Request.MODULE).equals("History"))
							this.setProperty(Request.MODULE, "History");
						
						if(__session.containsKey(Request.ADMIN) && __session.get(Request.ADMIN).equals("1")){
							
							if(__session.get(Request.MODULE).equals("Menu"))
								this.setProperty(Request.MODULE, "AdminMenu");
							
							else if(__session.get(Request.MODULE).equals("AddItem"))
								this.setProperty(Request.MODULE, "AddItem");
							
							else if(__session.get(Request.MODULE).equals("AddCategory"))
								this.setProperty(Request.MODULE, "AddCategory");
						}
						else {
							if(__session.get(Request.MODULE).equals("Menu"))
								this.setProperty(Request.MODULE, "UserMenu");
						}
					}
				}
			}
			
		// } protected {
			
		// } private {
			
		// }
	// }
}