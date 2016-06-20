package pl.edu.pk.shop.elements.user;


/**
 * @author Christopher Abram
 */
public class Admin extends User {
	// vars {
			
	// } methods {
			
		// public {
				
			public Admin(int ID){
				super(ID);
			}// end Admin
			
			public Admin(Admin ob){
				super(ob);
			}// end Admin
			
			/** Makes deep copy of object.
			 * @author Christopher Abram
			 * @return Admin - copy of object
			 **/
			public Admin clone(){
				return new Admin(this);
			}// end clone
	
		// } protected {
				
		// } private {
				
		// }
			
	// }
}