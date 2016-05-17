package pl.edu.pk.shop.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.sql.*;
import java.util.function.Consumer;

/** Results - container that stores database results.
 * It is also an Iterator.
 * @author Christopher Abram
 * @see Iterator
 **/
public class Results implements Iterator<Results.Row> {
	// vars {
		
		// Database results:
		private ArrayList<Row> __results = null;
		// List iterator:
		private Iterator<Row> __iterator = null;

	// } methods {
		// public {
			
			public Results(){
				__results = new ArrayList<Row>();
				__iterator = __results.iterator();
			}// end Results
			
			public Results(ArrayList<Row> results){
				__results = results;
				__iterator = __results.iterator();
			}// end Results
			
			public Results(ResultSet r) throws DatabaseException {
				__results = new ArrayList<Row>();
				try {
					ResultSetMetaData meta = r.getMetaData();
					int columnCount = meta.getColumnCount();
					
					while(r.next()){
						Row row = new Row();
						for(int i = 1; i <= columnCount; ++i){
							row.put(new String(meta.getColumnName(i).toLowerCase()), r.getString(i));
						}
						__results.add(row);
					}
					__iterator = __results.iterator();
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
				/*// vars {
					
				// } methods {
					// public {
						
					// } protected {
						
					// } private {
						
					// }*/
				// }
			}
	
			@Override
			public boolean hasNext() {
				if(__iterator != null)
					return __iterator.hasNext();
				return false;
			}// end hasNext
	
			@Override
			public Row next() {
				if(__iterator != null){
					return __iterator.next();
				}
				return null;
			}// end hasNext
	
			@Override
			public void remove() {
				if(__iterator != null)
					__iterator.remove();
				return;
			}// end remove
	
			@Override
			public void forEachRemaining(Consumer<? super Row> action) {
				// TODO Auto-generated method stub
				return;
			}
			
		// } protected {
			
			
			
		// } private {
			
			
			
		// }
	// }
}
