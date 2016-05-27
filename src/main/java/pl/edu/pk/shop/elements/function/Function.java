package pl.edu.pk.shop.elements.function;

/** Function - represents an instance of function, 
 * specified for User class
 * @author Christopher Abram
 **/
public class Function implements Cloneable {
	// vars {
		
		public FunctionData data;
		
	// } methods {
		// public {
			
			public Function(int ID){
				data = new FunctionData(ID);
			}// end Function
			
			public Function(Function ob){
				this.data = ob.data.clone();
			}// end Function
			
			/** Makes deep copy of object.
			 * @author Christopher Abram
			 * @return Function - copy of object
			 **/
			public Function clone(){
				return new Function(this);
			}// end clone
			
		// } protected {
			
		// } private {
			
		// }
	// }
}
