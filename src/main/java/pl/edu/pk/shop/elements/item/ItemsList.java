package pl.edu.pk.shop.elements.item;

import pl.edu.pk.shop.database.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

public class ItemsList extends ArrayList<Item> {
	// vars {
		
		protected int _categoryId;
		
	// } methods {
		// public {
			
			public ItemsList(){
				super();
			}
			
			public ItemsList(Collection<? extends Item> c){
				super(c);
			}
			
			public ItemsList(int categoryId){
				this._categoryId = categoryId;
				_load();
			}
			
			/** Re-loads items list. First clears all list and then invoke 
			 * protected _load method - which loads list of items from database.
			 * @author	Christopher Abram
			 * @return	-
			 **/
			public void reload(){
				this.clear();
				_load();
				return;
			}// end reload
	
		// } protected {
			
			protected void _load(){
				try {
					Database db = Database.getInstance();
					db.connect();
					db.query("SELECT id FROM item WHERE id_category = ?");
					db.prepare(_categoryId);
					if(db.execute()){
						Results res = db.getResults();
						ListIterator<Results.Row> iter = res.listIterator();
						while(iter.hasNext()){
							Results.Row row = iter.next();
							this.add(new Item(Integer.parseInt(row.get("id"))));
						}
					}
				} catch(DatabaseException dbe){
					System.out.println("Error: couldn't load list of item for category id: " + _categoryId);
				}
				return;
			}// end load
			
		// } private {
				
		// }
	// }
}
