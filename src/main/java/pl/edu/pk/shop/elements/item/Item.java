package pl.edu.pk.shop.elements.item;

/** Item - stores data connected with shop item.
 * @author Christopher Abram
 **/
public class Item implements Cloneable {
	// vars {
	
		// Item data:
		public ItemData data;
		
	// } methods {
		// public {
			
			public Item(int ID){
				data = new ItemData(ID);
			}// end Item
			
			public Item(Item ob){
				this.data = ob.data.clone();
			}// end Item
			
			/** Makes deep copy of object.
			 * @author Christopher Abram
			 * @return Item - copy of object
			 **/
			public Item clone(){
				return new Item(this);
			}// end clone
			
			
		// } protected {
			
			
			
		// } private {
			
			
			
		// }
	// }
}
