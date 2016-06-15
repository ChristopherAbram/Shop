package pl.edu.pk.shop.item;

import pl.edu.pk.shop.database.*;
import pl.edu.pk.shop.tabledata.TableData;
import java.util.HashMap;

public class ItemData implements TableData {
	// vars {
	
		// Attributes:
		public int id;
		public String itemname;
		public String itdescription;
		public float itemprice;
		public int quantity;
		public int category_id;
	
	// } methods {
		// public {
			
			public ItemData(){}// end ItemData
		
			
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
				Database db = Database.getInstance().connect();
				db.query("SELECT id, itemname, itdescription, itemprice, quantity, id_category FROM item WHERE id = ?");
				db.prepare(id);
				if(db.execute()){
					try {
						Results res = db.getResults();
						if(res.hasNext()){
							Results.Row row = res.next();
							id = Integer.parseInt(row.get("id"));
							itemname = row.get("itemname");
							itdescription = row.get("itdescription");
							itemprice = Float.parseFloat(row.get("itemprice"));
							quantity = Integer.parseInt(row.get("quantity"));
							category_id = Integer.parseInt(row.get("id_category"));
						}
					} catch(DatabaseException dbe){
						System.out.println("Warning: Unable to load item instance.");
					}
				}
				return false;
			}// end load
			
			/**Updates all information in SQL Server using UPDATE query.
			 * @author Christopher Abram
			 * @return boolean - true if update properly, false otherwise.
			 */
			public boolean update(){
				Database db = Database.getInstance().connect();
				db.query("UPDATE item SET itemname = ?, itdescription = ?, itemprice = ?, quantity = ?, id_category = ? WHERE id = ?");
				db.prepare(itemname, itdescription, itemprice, quantity, category_id, id);
				if(db.execute())
					return true;
					
				return false;
			}// end update
			
			/**Inserts row information to SQL Server using INSERT query.
			 * @author Christopher Abram
			 * @return boolean - true if insert properly, false otherwise.
			 */
			public boolean insert(){
				Database db = Database.getInstance().connect();
				db.query("INSERT INTO item(id, itemname, itdescription, itemprice, quantity, id_category) VALUES (?, ?, ?, ?, ?, ?)");
				db.prepare(itemname, itdescription, itemprice, quantity, category_id, id);
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
				db.query("DELETE FROM item WHERE id = ?");
				db.prepare(id);
				if(db.execute())
					return true;
				
				return false;
			} // end delete
			
			/**Gets all ItemData properties as HashMap.
			 * Keys name are the same as properties names.
			 * @author Christopher Abram
			 * @return HashMap<String, Object> - ItemData as HashMap
			 * @see java.util.HashMap
			 */
			public HashMap<String, Object> getAsHashMap(){
				HashMap<String, Object> map = new HashMap<String, Object>();
				
				// TODO: finish initialization of map 
				// done by:  Daria G
				map.put("id", id);
				map.put("itemname", itemname);
				map.put("itdescription", itdescription);
				map.put("itemprice", itemprice);
				map.put("quantity", quantity);
				map.put("id_category", category_id);
				
				return map;
			}// end getAsHashMap
			
		// } protected {
			
			
		// } private {
			
			
		// }
	// }
}
