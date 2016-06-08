package pl.edu.pk.shop.elements.user;


/**
 * @author Christopher Abram
 */
public class Client extends User {
	// vars {
			
	// } methods {
			
		// public {
				
			public Client(int ID){
				super(ID);
			}// end Client
			
			public Client(Client ob){
				super(ob);
			}// end Client
			
			/** Makes deep copy of object.
			 * @author Christopher Abram
			 * @return Client - copy of object
			 **/
			public Client clone(){
				return new Client(this);
			}// end clone
			
		// } protected {
				
		// } private {
				
		// }
			
	// }
}