package pl.edu.pk.shop.elements.category;

import java.util.ArrayList;
import java.util.ListIterator;

import pl.edu.pk.shop.database.*;
import static pl.edu.pk.shop.staticfunctions.Functions.*;
import pl.edu.pk.shop.elements.item.*;

/** Category - stores data connected with shop category,
 * enables references to parent category and sub-category,
 * at default they are set to null.
 * @author Christopher Abram
 **/
public class Category implements Cloneable {
	// vars {
	
		// Item data:
		public CategoryData data;
		
		// Category references:
		protected Category _parent;
		protected ArrayList<Category> _children = 	new ArrayList<Category>();
		
		// Items belonging to this category:
		protected ItemsList _items = 				new ItemsList();
		
	// } methods {
		// public {
			
			public Category(int ID){
				data = new CategoryData(ID);
			}// end Category
			
			public Category(Category ob){
				this.data = ob.data.clone();
				// Does not clone parent and children objects.
			}// end Category
			
			public Category getParent(){
				return _parent;
			}// end getParent
			
			public void setParent(final Category c){
				_parent = c;
				return;
			}// end setParent
			
			public ArrayList<Category> getSubCategories(){
				return _children;
			}// end getSubCategories
			
			public void setSubCategories(final ArrayList<Category> subs){
				_children = subs;
				return;
			}// end setSubCategories
			
			/** Initialize parent and children references.
			 * Loads all tree of categories.
			 * @author	Christopher Abram
			 * @return 	-
			 **/
			public void initTree(){
				Database db = Database.getInstance();
				db.connect();
				db.query("SELECT id FROM category WHERE id_parent = ?");
				db.prepare(data.id);
				if(db.execute()){
					try {
						Results r = db.getResults();
						ListIterator<Results.Row> iter = r.listIterator();
						while(iter.hasNext()){
							Results.Row row = iter.next();
							int id = Integer.parseInt(row.get("id"));
							
							if(id != this.data.id){
								// Create and add new category to children list:
								Category child = new Category(id);
								child._parent = this;
								child.initTree(); // loads recursively
								this._children.add(child);
							}
						}
					} catch(DatabaseException dbe){
						println("Unable to load tree of categories");
					}
				}
				return;
			}// end initTree
			
			/** Loades item list for this category.
			 * @author	Christopher Abram
			 * @return	boolean	- true if everything went ok, false otherwise
			 **/
			public boolean loadItems(){
				if(this.data != null){
					this._items = new ItemsList(this.data.id);
					return true;
				}
				return false;
			}// end loadItems
			
			public ItemsList getItems(){
				return this._items;
			}// end getItems
			
			/** Makes partly shadow copy of object.
			 * Clones only data object.
			 * @author Christopher Abram
			 * @return Category - copy of object
			 **/
			public Category clone(){
				return new Category(this);
			}// end clone
			
		// } protected {
			
			
		// } private {
			
			
		// }
	// }
}
