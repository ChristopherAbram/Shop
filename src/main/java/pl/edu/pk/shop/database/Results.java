package pl.edu.pk.shop.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.sql.*;
import java.util.function.Consumer;

/** Results - container that stores database results.
 * It is also an Iterator.
 * @author Christopher Abram
 * @see Iterator
 **/
public class Results extends ArrayList<Results.Row> {
	// vars {

	// } methods {
		// public {
			
			public Results(){
				super();
			}// end Results
			
			public Results(ArrayList<Row> results){
				super(results);
			}// end Results
			
			public Results(int initialCapacity){
				super(initialCapacity);
			}// end Results
			
			public Results(ResultSet r) throws DatabaseException {
				try {
					ResultSetMetaData meta = r.getMetaData();
					int columnCount = meta.getColumnCount();
					
					while(r.next()){
						Row row = new Row();
						for(int i = 1; i <= columnCount; ++i){
							row.put(new String(meta.getColumnName(i).toLowerCase()), r.getString(i));
						}
						this.add(row);
					}
				} catch (SQLException e){
					throw new DatabaseException(e.getMessage());
				}
			}// end Results
			
			/**Row - specifies the way, that one row from database query result will be supported.
			 * It is simply a HashMap<String, String>
			 * @author Christopher Abram
			 * @see HashMap
			 **/
			public class Row extends HashMap<String, String> {
				// vars {
					
				// } methods {
					// public {
						
					// } protected {
						
					// } private {
						
					// }
				// }
			}
			
		// } protected {
			
		// } private {
			
		// }
	// }
}
