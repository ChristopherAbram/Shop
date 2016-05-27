package pl.edu.pk.shop.elements.item;

import pl.edu.pk.shop.elements.tabledata.TableData;
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
				
				return false;
			}// end load
			
			/**Updates all information in SQL Server using UPDATE query.
			 * @author Christopher Abram
			 * @return boolean - true if update properly, false otherwise.
			 */
			public boolean update(){
				return false;
			}
			
			/**Inserts row information to SQL Server using INSERT query.
			 * @author Christopher Abram
			 * @return boolean - true if insert properly, false otherwise.
			 */
			public boolean insert(){
				return false;
			}
			
			/**Delete row in table using DELETE query.
			 * @author Christopher Abram
			 * @return boolean - true if delete properly, false otherwise.
			 */
			public boolean delete(){
				return false;
			}
			
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
