package pl.edu.pk.shop.elements.category;

import pl.edu.pk.shop.database.*;
import pl.edu.pk.shop.elements.tabledata.TableData;

import java.util.HashMap;
import java.util.ListIterator;

public class CategoryData implements TableData {
	// vars {
	
		// Attributes:
		public int id;
		public String categoryname;
		public String catdescription;
		public int id_parent;
	
	// } methods {
		// public {
			
			public CategoryData(){}// end CategoryData
		
			public CategoryData(CategoryData ob){
				this.id = ob.id;
				this.categoryname = ob.categoryname;
				this.catdescription = ob.catdescription;
				this.id_parent = ob.id_parent;
			}// end CategoryData
			
			public CategoryData(int ID){
				if(ID > -1){
					id = ID;
					load();
				}
			}// end CategoryData
			
			/**Loads all information from SQL Server.
			 * @author Christopher Abram
			 * @return void
			 */
			public boolean load(){
				Database db = Database.getInstance();
				db.connect();
				db.query("SELECT id, categoryname, catdescription, id_parent FROM category WHERE id = ?");
				db.prepare(id);
				if(db.execute()){
					try {
						Results res = db.getResults();
						ListIterator<Results.Row> iter = res.listIterator();
						if(iter.hasNext()){
							Results.Row row = iter.next();
							id = Integer.parseInt(row.get("id"));
							categoryname = row.get("categoryname");
							catdescription = row.get("catdescription");
							id_parent = Integer.parseInt(row.get("id_parent"));
							return true;
						}
					} catch(DatabaseException dbe){
						System.out.println("Warning: Unable to load category instance.");
					}
				}
				return false;
			}// end load
			
			/**Updates all information in SQL Server using UPDATE query.
			 * @author Christopher Abram
			 * @return boolean - true if update properly, false otherwise.
			 */
			public boolean update(){
				Database db = Database.getInstance();
				db.connect();
				db.query("UPDATE category SET categoryname = ?, catdescription = ?, id_parent = ? WHERE id = ?");
				db.prepare(categoryname, catdescription, id_parent, id);
				if(db.execute())
					return true;
				return false;
			}// end update
			
			/**Inserts row information to SQL Server using INSERT query.
			 * @author Christopher Abram
			 * @return boolean - true if insert properly, false otherwise.
			 */
			public boolean insert(){
				Database db = Database.getInstance();
				db.connect();
				db.query("INSERT INTO category(id, categoryname, catdescription, id_parent) VALUES (?, ?, ?, ?)");
				db.prepare(id, categoryname, catdescription, id_parent);
				if(db.execute())
					return true;
				return false;
			}// end insert
			
			/**Delete row in table using DELETE query.
			 * @author Christopher Abram
			 * @return boolean - true if delete properly, false otherwise.
			 */
			public boolean delete(){
				Database db = Database.getInstance();
				db.connect();
				db.query("DELETE FROM category WHERE id = ?");
				db.prepare(id);
				if(db.execute())
					return true;
				return false;
			}// end delete
			
			/**Gets all CategoryData properties as HashMap.
			 * Keys name are the same as properties names.
			 * @author Christopher Abram
			 * @return HashMap<String, Object> - CategoryData as HashMap
			 * @see java.util.HashMap
			 */
			public HashMap<String, Object> getAsHashMap(){
				HashMap<String, Object> map = new HashMap<String, Object>();
				
				map.put("id", id);
				// TODO: finish initialization of map
				
				return map;
			}// end getAsHashMap
			
			/** Makes deep copy of object.
			 * @author Christopher Abram
			 * @return ItemData - copy of object
			 **/
			public CategoryData clone(){
				return new CategoryData(this);
			}// end clone
			
		// } protected {
			
			
		// } private {
			
			
		// }
	// }
}
