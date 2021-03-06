package pl.edu.pk.shop.elements.user;

import java.util.ListIterator;

import pl.edu.pk.shop.database.*;

/**
 * @author Christopher Abram
 *
 */
public abstract class User implements Cloneable {
	// vars {
		
		public UserData data = null;
		protected String _sqlByID = 
				"SELECT " +
				"id, type, name, surname, age " +
				"FROM user " +
				"WHERE id = ? " +
				"FETCH FIRST 1 ROW ONLY";
		
		
	// } methods {
		
		// public {
		
			public User(int ID){
				data = new UserData(ID);
			}
			
			public User(User ob){
				this.data = ob.data.clone();
			}// end User
		
			/**Performing simple authentication by login - which could be anything 
			 * and password.
			 * @author Christopher Abram
			 * @param String login - login e.g.: email or username
			 * @param String password - hashed password
			 * @return int - an identifier of the user if user exists or -1 if something went wrong.
			 */
			public static int authentication(String login, String password){
				int id = -1;
				Database db = Database.getInstance();
				db.connect();
				db.query("SELECT id FROM users WHERE email LIKE ? AND password LIKE ? FETCH FIRST 1 ROW ONLY");
				db.prepare(login, password);
				if(db.execute()){
					Results res = db.getResults();
					ListIterator<Results.Row> iter = res.listIterator();
					if(iter.hasNext()){
						Results.Row row = iter.next();
						id = Integer.parseInt(row.get("id"));
					}
				}
				return id;
			}// end authentication
			
			public static boolean update(UserData data){
				// TODO: write implementation of update
				return false;
			}// end update
			
			public static boolean register(UserData data){
				// TODO: write registration code
				return false;
			}// end register
			
			public static boolean delete(int ID){
				// TODO: write delete user code
				return false;
			}// end delete
		
		// } protected {
			
		// } private {
			
		// }
		
	// }
}