package pl.edu.pk.shop.elements.user;


/**
 * @author Christopher Abram
 */
public class Guest extends User {
	// vars {
			
	// } methods {
			
		// public {
				
			public Guest(int ID){
				super(0);
			}// end Guest
			
			public Guest(Guest ob){
				super(ob);
			}// end Guest
			
			/** Makes deep copy of object.
			 * @author Christopher Abram
			 * @return Guest - copy of object
			 **/
			public Guest clone(){
				return new Guest(this);
			}// end clone
			
		// } protected {
				
		// } private {
				
		// }
			
	// }
}