package pl.edu.pk.shop.elements.address;

/** Address - represents an instance of address, 
 * specified for User class
 * @author Christopher Abram
 **/
public class Address implements Cloneable {
	// vars {
	
		public AddressData data;
	
	// } methods {
		// public {
				
			public Address(int ID){
				data = new AddressData(ID);
			}
			
			public Address(Address ob){
				this.data = ob.data.clone();
			}// end Address
			
			/** Makes deep copy of object.
			 * @author Christopher Abram
			 * @return Address - copy of object
			 **/
			public Address clone(){
				return new Address(this);
			}// end clone
	
		// } protected {
				
		// } private {
				
		// }
	// }
}
