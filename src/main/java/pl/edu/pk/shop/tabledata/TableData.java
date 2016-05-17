package pl.edu.pk.shop.tabledata;

import java.util.HashMap;

/** Interface defining minimal interface for classes 
 * which represent database row from appropriate table
 * @author Christopher Abram
 * */
public interface TableData {
	
	/**Loads all information from SQL Server using SELECT query.
	 * @author Christopher Abram
	 * @return void
	 */
	public boolean load();
	
	/**Updates all information in SQL Server using UPDATE query.
	 * @author Christopher Abram
	 * @return boolean - true if update properly, false otherwise.
	 */
	public boolean update();
	
	/**Inserts row information to SQL Server using INSERT query.
	 * @author Christopher Abram
	 * @return boolean - true if insert properly, false otherwise.
	 */
	public boolean insert();
	
	/**Delete row in table using DELETE query.
	 * @author Christopher Abram
	 * @return boolean - true if delete properly, false otherwise.
	 */
	public boolean delete();
	
	/**Gets all row data attributes as HashMap.
	 * Keys name are the same as attributes names.
	 * @author Christopher Abram
	 * @return HashMap<String, Object> - row data as HashMap
	 * @see java.util.HashMap
	 */
	public HashMap<String, Object> getAsHashMap();
	
}
