package pl.edu.pk.shop.elements.category;

import java.util.ArrayList;

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
		protected ArrayList<Category> _children;
		
		// Items belonging to this category:
		protected ItemsList _items;
		
	// } methods {
		// public {
			
			public Category(int ID){
				data = new CategoryData(ID);
			}// end Category
			
			public Category(Category ob){
				this.data = ob.data.clone();
				// Don't clone parent and children objects.
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
				// TODO: write semantics of creation a tree of categories.
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
