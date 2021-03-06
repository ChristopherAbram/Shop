package pl.edu.pk.shop.elements.address;

import java.util.HashMap;
import java.util.ListIterator;

import pl.edu.pk.shop.database.*;
import pl.edu.pk.shop.elements.tabledata.TableData;

/**Stores address's data.
 * @author Christopher Abram
 */
public class AddressData implements TableData {
	// vars {
	
			public int id;
			public String street;
			public String flatnumber;
			public String cityname;
			public String zipcode;
			
	// } methods {
		// public {
			
			public AddressData(){}
			
			public AddressData(AddressData ob){
				this.id = ob.id;
				this.street = ob.street;
				this.flatnumber = ob.flatnumber;
				this.cityname = ob.cityname;
				this.zipcode = ob.zipcode;
			}// end AddressData
				
			public AddressData(int ID){
				if(ID > -1){
					id = ID;
					load();
				}
			}// end UserData
			
			/**Loads all information from SQL Server.
			 * @author Christopher Abram
			 * @return void
			 */
			public boolean load(){
				try {
					Database db = Database.getInstance();
					db.connect();
					db.query("SELECT id, street, flatnumber, cityname, zipcode FROM address WHERE id = ?");
					db.prepare(id);
					if(db.execute()){
						Results res = db.getResults();
						ListIterator<Results.Row> iter = res.listIterator();
						if(iter.hasNext()){
							Results.Row row = iter.next();
							id = Integer.parseInt(row.get("id"));
							street = row.get("street");
							flatnumber = row.get("flatnumber");
							cityname = row.get("cityname");
							zipcode = row.get("zipcode");
							//db.close();
							return true;
						}
					}
					//db.close();
				} catch(DatabaseException dbe){
					System.out.println("Warning: Unable to load address instance.");
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
				db.query("UPDATE address SET street = ?, flatnumber = ?, cityname = ?, zipcode = ? WHERE id = ?");
				db.prepare(street, flatnumber, cityname, zipcode, id);
				if(db.execute())
					return true;
				return false;
			}// end update
			
			/**Inserts row information to SQL Server using INSERT query.
			 * @author Christopher Abram
			 * @return boolean - true if insert properly, false otherwise.
			 */
			public boolean insert(){
				try {
					this.id = this.nextID();
					Database db = Database.getInstance();
					db.connect();
					db.query("INSERT INTO address(id, street, flatnumber, cityname, zipcode) VALUES (?, ?, ?, ?, ?)");
					//System.out.println(id);
					db.prepare(id, street, flatnumber, cityname, zipcode);
					if(db.execute()){
						//db.close();
						return true;
					}
					//db.close();
				} catch(DatabaseException de){
					System.out.println("Error: Unable to insert address instance.");
				}
				return false;
			}// end insert
			
			/**Delete row in table using DELETE query.
			 * @author Christopher Abram
			 * @return boolean - true if delete properly, false otherwise.
			 */
			public boolean delete(){
				try {
					Database db = Database.getInstance();
					db.connect();
					db.query("DELETE FROM address WHERE id = ?");
					db.prepare(id);
					if(db.execute()){
						//db.close();
						return true;
					}
					//db.close();
				} catch(DatabaseException de){
					System.out.println("Error: Unable to delete address instance.");
				}
				return false;
			}// end delete
			
			public int nextID(){
				int ID = -1;
				try {
					Database db = Database.getInstance();
					db.connect();
					db.query("SELECT address_seq.nextval AS id FROM dual");
					//db.prepare();
					if(db.execute()){
						Results res = db.getResults();
						ListIterator<Results.Row> iter = res.listIterator();
						while(iter.hasNext()){
							Results.Row row = iter.next();
							ID = Integer.parseInt(row.get("id"));
						}
					}
				} catch(DatabaseException dbe){
					System.out.println("Error: unable to get next Address id.");
				}
				return ID;
			}// end nextID
			
			/**Gets all AddressData properties as HashMap.
			 * Keys name are the same as properties names.
			 * @author Christopher Abram
			 * @return HashMap<String, Object> - AddressData as HashMap
			 * @see java.util.HashMap
			 */
			public HashMap<String, Object> getAsHashMap(){
				HashMap<String, Object> map = new HashMap<String, Object>();
				
				map.put("id", id);
				map.put("street", street);
				map.put("flatnumber", flatnumber);
				map.put("cityname", cityname);
				map.put("zipcode", zipcode);
				
				return map;
			}// end getAsHashMap
			
			/** Makes deep copy of object.
			 * @author Christopher Abram
			 * @return AddressData - copy of object
			 **/
			public AddressData clone(){
				return new AddressData(this);
			}// end clone
			
		// } protected {
			
		// } private {
			
		// }
	// }
}
