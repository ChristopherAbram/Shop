package pl.edu.pk.shop.elements.purchasebase;

import pl.edu.pk.shop.database.Database;
import pl.edu.pk.shop.database.DatabaseException;
import pl.edu.pk.shop.database.Results;
import pl.edu.pk.shop.elements.item.Item;
import pl.edu.pk.shop.elements.tabledata.TableData;
import pl.edu.pk.shop.elements.user.User;

import java.util.HashMap;
import java.util.ListIterator;

public class PurchaseBaseData implements TableData {
	// vars {
	
		// Attributes:
		public int id;
		public Item item;
		public int itemquantity;
		public int id_user;
		public String b_date;
		
	// } methods {
		// public {
				
			public PurchaseBaseData(){}// end PurchaseBaseData
			
			public PurchaseBaseData(PurchaseBaseData ob){
				this.id = ob.id;
				this.item = ob.item.clone();
				this.itemquantity = ob.itemquantity;
				this.id_user = ob.id_user;
				this.b_date = ob.b_date;
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
				db.query("SELECT id, id_item, itemquantity, id_user, b_date FROM purchase_base WHERE id = ?");
				db.prepare(id);
				if(db.execute()){
					try {
						Results res = db.getResults();
						ListIterator<Results.Row> iter = res.listIterator();
						if(iter.hasNext()){
							Results.Row row = iter.next();
							id = Integer.parseInt(row.get("id"));
							item = new Item(Integer.parseInt(row.get("id_item")));
							itemquantity = Integer.parseInt(row.get("itemquantity"));
							id_user = Integer.parseInt(row.get("id_user"));
							b_date = row.get("b_date");
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
				db.query("UPDATE purchase_base SET id_item = ?, itemquantity = ?, id_user = ?, b_date = ? WHERE id = ?");
				db.prepare(item.data.id, itemquantity, id_user, b_date, id);
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
				db.query("INSERT INTO purchase_base(id, id_item, itemquantity, id_user) VALUES (pb_seq.nextval, ?, ?, ?)");
				db.prepare(item.data.id, itemquantity, id_user);
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
				db.query("DELETE FROM purchase_base WHERE id = ?");
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
