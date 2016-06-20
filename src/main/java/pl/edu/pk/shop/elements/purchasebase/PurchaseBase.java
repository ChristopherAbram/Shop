package pl.edu.pk.shop.elements.purchasebase;

/** PurchaseBase - .
 * @author Christopher Abram
 **/
public class PurchaseBase implements Cloneable {
	// vars {
	
			// PurchaseBase data:
			public PurchaseBaseData data;
			
		// } methods {
			// public {
				
				public PurchaseBase(int ID){
					data = new PurchaseBaseData(ID);
				}// end PurchaseBase
				
				public PurchaseBase(PurchaseBase ob){
					this.data = ob.data.clone();
				}// end PurchaseBase
				
				/** Makes deep copy of object.
				 * @author Christopher Abram
				 * @return PurchaseBase - copy of object
				 **/
				public PurchaseBase clone(){
					return new PurchaseBase(this);
				}// end clone
		
			// } protected {
				
			// } private {
				
			// }
		// }
}