package pl.edu.pk.shop.elements.function;

import java.util.HashMap;
import java.util.ListIterator;

import pl.edu.pk.shop.database.*;
import pl.edu.pk.shop.elements.tabledata.TableData;

/**Stores function's data.
 * @author Christopher Abram
 */
public class FunctionData implements TableData {
	// vars {
	
			public int id;
			public String function_name;
			public int access_level;
			
	// } methods {
		// public {
			
			public FunctionData(){}
			
			public FunctionData(FunctionData ob){
				this.id = ob.id;
				// ...
			}// end FunctionData
				
			public FunctionData(int ID){
				if(ID > -1){
					id = ID;
					load();
				}
			}// end FunctionData
			
			/**Loads all information from SQL Server.
			 * @author Christopher Abram
			 * @return void
			 */
			public boolean load(){
				Database db = Database.getInstance();
				db.connect();
				db.query("SELECT id, function_name, access_level FROM function WHERE id = ?");
				db.prepare(id);
				if(db.execute()){
					try {
						Results res = db.getResults();
						ListIterator<Results.Row> iter = res.listIterator();
						if(iter.hasNext()){
							Results.Row row = iter.next();
							id = Integer.parseInt(row.get("id"));
							function_name = row.get("function_name");
							access_level = Integer.parseInt(row.get("access_level"));
							return true;
						}
					} catch(DatabaseException dbe){
						System.out.println("Warning: Unable to load function instance.");
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
				db.query("UPDATE function SET function_name = ?, access_level = ? WHERE id = ?");
				db.prepare(function_name, access_level, id);
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
				db.query("INSERT INTO function(id, function_name, access_level) VALUES (?, ?, ?)");
				db.prepare(id, function_name, access_level);
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
				db.query("DELETE FROM function WHERE id = ?");
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
					db.query("SELECT category_seq.nextval AS id FROM dual");
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
					System.out.println("Error: unable to get next Address id.");
				}
				return ID;
			}// end nextID
			
			/**Gets all FunctionData properties as HashMap.
			 * Keys name are the same as properties names.
			 * @author Christopher Abram
			 * @return HashMap<String, Object> - FunctionData as HashMap
			 * @see java.util.HashMap
			 */
			public HashMap<String, Object> getAsHashMap(){
				HashMap<String, Object> map = new HashMap<String, Object>();
				
				map.put("id", id);
				map.put("function_name", function_name);
				map.put("access_level", access_level);
				
				return map;
			}// end getAsHashMap
			
			/** Makes deep copy of object.
			 * @author Christopher Abram
			 * @return FunctionData - copy of object
			 **/
			public FunctionData clone(){
				return new FunctionData(this);
			}// end clone
			
		// } protected {
			
		// } private {
			
		// }
	// }
}
