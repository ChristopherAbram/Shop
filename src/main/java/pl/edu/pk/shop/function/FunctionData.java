package pl.edu.pk.shop.function;

import java.util.HashMap;

import pl.edu.pk.shop.database.*;
import pl.edu.pk.shop.tabledata.TableData;

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
						if(res.hasNext()){
							Results.Row row = res.next();
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
			
		// } protected {
			
		// } private {
			
		// }
	// }
}
