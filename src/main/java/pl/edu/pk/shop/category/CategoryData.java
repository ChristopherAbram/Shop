package pl.edu.pk.shop.category;

	import java.util.HashMap;

	import pl.edu.pk.shop.database.*;
	import pl.edu.pk.shop.tabledata.TableData;

	/**Categories data.
	 * @author Daria G
	 */
	public class CategoryData implements TableData {
		// vars {
		
				public int id;
				public String categoryname;
				public String catdescription;
				public int parent_id;
								
		// } methods {
			// public {
				
				public CategoryData(){}
					
				public CategoryData(int ID){
					if(ID > -1){
						id = ID;
						load();
					}
				}
				
				/**Loads all information from SQL Server.
				 * @author Daria G
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
							if(res.hasNext()){
								Results.Row row = res.next();
								id = Integer.parseInt(row.get("id"));
								categoryname = row.get("categoryname");
								catdescription = row.get("catdescription");
								parent_id = Integer.parseInt(row.get("id_parent"));
								return true;
							}
						} catch(DatabaseException dbe){
							System.out.println("Error: " + dbe.getMessage());
						}
					}
					return false;
				}// end load
				
				/**Updates all information in SQL Server using UPDATE query.
				 * @author Daria G
				 * @return boolean - true if update properly, false otherwise.
				 */
				public boolean update(){
				try{
					Database db = Database.getInstance();
					db.connect();
					db.query("UPDATE category SET id = ?, categoryname = ?, catdescription = ?, id_parent = ? WHERE id = ?");
					db.prepare(categoryname, catdescription, parent_id, id);
					if(db.execute())
						return true;
				} catch(DatabaseException dbe) {
					System.out.println("Error: " + dbe.getMessage());
				}
					return false;
				}// end update
				
				/**Inserts row information to SQL Server using INSERT query.
				 * @author Daria G
				 * @return boolean - true if insert properly, false otherwise.
				 */
				public boolean insert(){
				try{
					Database db = Database.getInstance();
					db.connect();
					db.query("INSERT INTO category(id, categoryname, catdescription, id_parent) VALUES (?, ?, ?, ?)");
					db.prepare(id, categoryname, catdescription, parent_id);
					if(db.execute())
						return true;
				} catch(DatabaseException dbe) {
					System.out.println("Error: " + dbe.getMessage());
				}
					return false;
				
				}// end insert
				
				/**Delete row in table using DELETE query.
				 * @author Daria G
				 * @return boolean - true if delete properly, false otherwise.
				 */
				public boolean delete(){
				try{
					Database db = Database.getInstance();
					db.connect();
					db.query("DELETE FROM category WHERE id = ?");
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
				 * @author Daria G
				 * @return HashMap<String, Object> - AddressData as HashMap
				 * @see java.util.HashMap
				 */
				public HashMap<String, Object> getAsHashMap(){
					HashMap<String, Object> map = new HashMap<String, Object>();
					
					map.put("id", id);
					map.put("categoryname", categoryname);
					map.put("catdescription", catdescription);
					map.put("id_parent", parent_id);
										
					return map;
				}// end getAsHashMap
				
			// } protected {
				
			// } private {
				
			// }
		// }
	}

