package pl.edu.pk.shop.address;

import java.util.HashMap;

import pl.edu.pk.shop.database.*;
import pl.edu.pk.shop.tabledata.TableData;

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
				Database db = Database.getInstance();
				db.connect();
				db.query("SELECT id, street, flatnumber, cityname, zipcode FROM address WHERE id = ?");
				db.prepare(id);
				if(db.execute()){
					try {
						Results res = db.getResults();
						if(res.hasNext()){
							Results.Row row = res.next();
							id = Integer.parseInt(row.get("id"));
							street = row.get("street");
							flatnumber = row.get("flatnumber");
							cityname = row.get("cityname");
							zipcode = row.get("zipcode");
							return true;
						}
					} catch(DatabaseException dbe){
						System.out.println("Error: " + dbe.getMessage());
					}
				}
				return false;
			}// end load
			
			/**Updates all information in SQL Server using UPDATE query.
			 * @author Christopher Abram
			 * @return boolean - true if update properly, false otherwise.
			 */
			public boolean update(){
			try{
				Database db = Database.getInstance();
				db.connect();
				db.query("UPDATE address SET street = ?, flatnumber = ?, cityname = ?, zipcode = ? WHERE id = ?");
				db.prepare(street, flatnumber, cityname, zipcode, id);
				if(db.execute())
					return true;
			} catch(DatabaseException dbe) {
				System.out.println("Error: " + dbe.getMessage());
			}
				return false;
			}// end update
			
			/**Inserts row information to SQL Server using INSERT query.
			 * @author Christopher Abram
			 * @return boolean - true if insert properly, false otherwise.
			 */
			public boolean insert(){
			try{
				Database db = Database.getInstance();
				db.connect();
				db.query("INSERT INTO address(id, street, flatnumber, cityname, zipcode) VALUES (?, ?, ?, ?, ?)");
				db.prepare(id, street, flatnumber, cityname, zipcode);
				if(db.execute())
					return true;
			} catch(DatabaseException dbe) {
				System.out.println("Error: " + dbe.getMessage());
			}
				return false;
			
			}// end insert
			
			/**Delete row in table using DELETE query.
			 * @author Christopher Abram
			 * @return boolean - true if delete properly, false otherwise.
			 */
			public boolean delete(){
			try{
				Database db = Database.getInstance();
				db.connect();
				db.query("DELETE FROM address WHERE id = ?");
				db.prepare(id);
				if(db.execute())
					return true;
			} catch(DatabaseException dbe) {
				System.out.println("Error: " + dbe.getMessage());
			}
				return false;
			}// end delete
			
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
			
		// } protected {
			
		// } private {
			
		// }
	// }
}
