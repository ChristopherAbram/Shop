package pl.edu.pk.shop.elements.item;

import pl.edu.pk.shop.database.Database;
import pl.edu.pk.shop.database.DatabaseException;
import pl.edu.pk.shop.database.Results;
import pl.edu.pk.shop.elements.tabledata.TableData;
import java.util.HashMap;
import java.util.ListIterator;

public class ItemData implements TableData {
	// vars {
	
		// Attributes:
		public int id;
		public String itemname;
		public String itdescription;
		public float itemprice;
		public int quantity;
		public int id_category;
	
	// } methods {
		// public {
			
			public ItemData(){}// end ItemData
		
			public ItemData(ItemData ob){
				this.id = ob.id;
				// ...
			}// end ItemData
			
			public ItemData(int ID){
				if(ID > -1){
					id = ID;
					load();
				}
			}// end ItemData
			
			/**Loads all information from SQL Server.
			 * @author Christopher Abram
			 * @return void
			 */
			public boolean load(){
				Database db = Database.getInstance();
				db.connect();
				db.query("SELECT id, itemname, itdescription, itemprice, quantity, id_category FROM item WHERE id = ?");
				db.prepare(id);
				if(db.execute()){
					try {
						Results res = db.getResults();
						ListIterator<Results.Row> iter = res.listIterator();
						if(iter.hasNext()){
							Results.Row row = iter.next();
							id = Integer.parseInt(row.get("id"));
							itemname = row.get("itemname");
							itdescription = row.get("itdescription");
							itemprice = Float.parseFloat(row.get("itemprice"));
							quantity = Integer.parseInt(row.get("quantity"));
							id_category = Integer.parseInt(row.get("id_category"));
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
				db.query("UPDATE item SET itemname = ?, itdescription = ?, itemprice = ?, quantity = ?, id_category = ? WHERE id = ?");
				db.prepare(itemname, itdescription, itemprice, quantity, id_category, id);
				if(db.execute())
					return true;
				return false;
			}
			
			/**Inserts row information to SQL Server using INSERT query.
			 * @author Christopher Abram
			 * @return boolean - true if insert properly, false otherwise.
			 */
			public boolean insert(){
				id = nextID();
				Database db = Database.getInstance();
				db.connect();
				db.query("INSERT INTO item(id, itemname, itdescription, itemprice, quantity, id_category) VALUES (?, ?, ?, ?, ?, ?)");
				db.prepare(id, itemname, itdescription, itemprice, quantity, id_category);
				if(db.execute())
					return true;
				return false;
			}
			
			/**Delete row in table using DELETE query.
			 * @author Christopher Abram
			 * @return boolean - true if delete properly, false otherwise.
			 */
			public boolean delete(){
				Database db = Database.getInstance();
				db.connect();
				db.query("DELETE FROM item WHERE id = ?");
				db.prepare(id);
				if(db.execute())
					return true;
				return false;
			}
			
			public int nextID(){
				int ID = -1;
				try {
					Database db = Database.getInstance();
					db.connect();
					db.query("SELECT item_seq.nextval AS id FROM dual");
					db.prepare();
					if(db.execute()){
						Results res = db.getResults();
						ListIterator<Results.Row> iter = res.listIterator();
						while(iter.hasNext()){
							Results.Row row = iter.next();
							ID = Integer.parseInt(row.get("id"));
						}
					}
				} catch(DatabaseException dbe){
					System.out.println("Error: unable to get next Item id.");
				}
				return ID;
			}// end nextID
			
			/**Gets all ItemData properties as HashMap.
			 * Keys name are the same as properties names.
			 * @author Christopher Abram
			 * @return HashMap<String, Object> - ItemData as HashMap
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
			public ItemData clone(){
				return new ItemData(this);
			}// end clone
			
		// } protected {
			
			
		// } private {
			
			
		// }
	// }
}
