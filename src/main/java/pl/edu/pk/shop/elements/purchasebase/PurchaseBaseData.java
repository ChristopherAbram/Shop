package pl.edu.pk.shop.elements.purchasebase;

import pl.edu.pk.shop.database.Database;
import pl.edu.pk.shop.database.DatabaseException;
import pl.edu.pk.shop.database.Results;
import pl.edu.pk.shop.elements.tabledata.TableData;
import java.util.HashMap;
import java.util.ListIterator;

public class PurchaseBaseData implements TableData {
	// vars {
	
		// Attributes:
		public int id;
		
	// } methods {
		// public {
				
			public PurchaseBaseData(){}// end PurchaseBaseData
			
			public PurchaseBaseData(PurchaseBaseData ob){
				this.id = ob.id;
				// ...
			}// end ItemData
				
			public PurchaseBaseData(int ID){
				if(ID > -1){
					id = ID;
					load();
				}
			}// end PurchaseBaseData
				
			/**Loads all information from SQL Server.
			* @author Christopher Abram
			* @return void
			*/
			public boolean load(){
				Database db = Database.getInstance();
				db.connect();
				db.query("SELECT id, FROM purchasebase WHERE id = ?");
				db.prepare(id);
				if(db.execute()){
					try {
						Results res = db.getResults();
						ListIterator<Results.Row> iter = res.listIterator();
						if(iter.hasNext()){
							Results.Row row = iter.next();
							id = Integer.parseInt(row.get("id"));
							return true;
						}
					} catch(DatabaseException dbe){
						System.out.println("Warning: Unable to load purchasebase instance.");
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
				db.query("UPDATE purchasebase SET ... WHERE id = ?");
				db.prepare(id);
				if(db.execute())
					return true;
				return false;
			}
				
			/**Inserts row information to SQL Server using INSERT query.
			* @author Christopher Abram
			* @return boolean - true if insert properly, false otherwise.
			*/
			public boolean insert(){
				Database db = Database.getInstance();
				db.connect();
				db.query("INSERT INTO purchasebase(id, ) VALUES (?, )");
				db.prepare(id);
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
				db.query("DELETE FROM purchasebase WHERE id = ?");
				db.prepare(id);
				if(db.execute())
					return true;
				return false;
			}
				
			/**Gets all ItemData properties as HashMap.
			* Keys name are the same as properties names.
			* @author Christopher Abram
			* @return HashMap<String, Object> - PurchaseBaseData as HashMap
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
			* @return PurchaseBaseData - copy of object
			**/
			public PurchaseBaseData clone(){
				return new PurchaseBaseData(this);
			}// end clone
			
		// } protected {
			
		// } private {
			
		// }
	// }
}
