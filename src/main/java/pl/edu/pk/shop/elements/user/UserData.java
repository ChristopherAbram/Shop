package pl.edu.pk.shop.elements.user;

import java.util.HashMap;
import java.util.ListIterator;

import pl.edu.pk.shop.database.*;
import pl.edu.pk.shop.elements.address.Address;
import pl.edu.pk.shop.elements.function.Function;
import pl.edu.pk.shop.elements.tabledata.TableData;

/**Stores user's data.
 * @author Christopher Abram
 */
public class UserData implements TableData {
	// vars {
	
		public int id;
		public String first_name;
		public String second_name;
		public Function function;
		public Address address;
		public String email;
		public String phonenumber;
		public String password;
		
	// } methods {
		
		public UserData(){}
		
		public UserData(UserData ob){
			this.id = ob.id;
			// TODO: finish coping...
		}// end UserData
		
		public UserData(int ID){
			if(ID > -1){
				id = ID;
				load();
			}
		}// end UserData
		
		/**Loads all information from SQL Server.
		 * @author Christopher Abram
		 * @param int id - identifier of user.
		 * @return void
		 */
		public boolean load(){
			if(id == 0){
				first_name = "GUEST";
				second_name = "";
				function = new Function(1); // Guest function
				address = null;
				email = "";
				phonenumber = "";
				password = "";
				return true;
			} else {
				try {
					Database db = Database.getInstance();
					db.connect();
					db.query("SELECT id, first_name, second_name, id_function, id_address, email, phonenumber, password FROM users WHERE id = ?");
					db.prepare(id);
					if(db.execute()){
						Results res = db.getResults();
						ListIterator<Results.Row> iter = res.listIterator();
						if(iter.hasNext()){
							Results.Row row = iter.next();
							id = Integer.parseInt(row.get("id"));
							first_name = row.get("first_name");
							second_name = row.get("second_name");
							function = new Function(Integer.parseInt(row.get("id_function")));
							address = new Address(Integer.parseInt(row.get("id_address")));
							email = row.get("email");
							phonenumber = row.get("phonenumber");
							password = row.get("password");
							//db.close();
							return true;
						}
					}
					//db.close();
				} catch(DatabaseException dbe){
					System.out.println("Warning: Unable to load user instance.");
				}
			}
			return false;
		}// end load
		
		/**Updates all information in SQL Server using UPDATE query.
		 * @author Christopher Abram
		 * @return boolean - true if update properly, false otherwise.
		 */
		public boolean update(){
			if(id == 0)
				return true;
			try {
				Database db = Database.getInstance();
				db.connect();
				db.query("UPDATE users SET first_name = ?, second_name = ?, id_function = ?, id_address = ?, email = ?, phonenumber = ?, password = ? WHERE id = ?");
				db.prepare(first_name, second_name, function.data.id, address.data.id, email, phonenumber, password, id);
				if(db.execute()){
					//db.close();
					return true;
				}
				//db.close();
			} catch(DatabaseException dbe){
				System.out.println("Warning: Unable to update user instance.");
			}
			return false;
		}// end update
		
		/**Inserts row information to SQL Server using INSERT query.
		 * @author Christopher Abram
		 * @return boolean - true if insert properly, false otherwise.
		 */
		public boolean insert(){
			//if(id == 0)
			//	return true;
			try {
				id = nextID();
				Database db = Database.getInstance();
				db.connect();
				db.query("INSERT INTO users(id, first_name, second_name, id_function, id_address, email, phonenumber, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
				db.prepare(id, first_name, second_name, function.data.id, address.data.id, email, phonenumber, password);
				if(db.execute()){
					//db.close();
					return true;
				}
				//db.close();
			} catch(DatabaseException dbe){
				System.out.println("Warning: Unable to insert user instance.");
			}	
			return false;
		}// end insert
		
		/**Delete row in table using DELETE query.
		 * @author Christopher Abram
		 * @return boolean - true if delete properly, false otherwise.
		 */
		public boolean delete(){
			if(id == 0)
				return true;
			try {
				Database db = Database.getInstance();
				db.connect();
				db.query("DELETE FROM users WHERE id = ?");
				db.prepare(id);
				if(db.execute()){
					//db.close();
					return true;
				}
				//db.close();
			} catch(DatabaseException dbe){
				System.out.println("Warning: Unable to delete user instance.");
			}
			return false;
		}// end delete
		
		public int nextID(){
			int ID = -1;
			try {
				Database db = Database.getInstance();
				db.connect();
				db.query("SELECT users_seq.nextval AS id FROM dual");
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
				System.out.println("Error: unable to get next User id.");
			}
			return ID;
		}// end nextID
		
		/**Gets all UserData properties as HashMap.
		 * Keys name are the same as properties names.
		 * @author Christopher Abram
		 * @return HashMap<String, Object> - UserData as HashMap
		 * @see java.util.HashMap
		 */
		public HashMap<String, Object> getAsHashMap(){
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", id);
			map.put("first_name", first_name);
			map.put("second_name", second_name);
			map.put("function", function);
			map.put("address", address);
			map.put("email", email);
			map.put("phonenumber", phonenumber);
			map.put("password", password);
			
			return map;
		}// end getAsHashMap
		
		/** Makes deep copy of object.
		 * @author Christopher Abram
		 * @return UserData - copy of object
		 **/
		public UserData clone(){
			return new UserData(this);
		}// end clone
		
	// }
}
