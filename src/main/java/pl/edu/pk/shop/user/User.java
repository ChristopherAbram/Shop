package pl.edu.pk.shop.user;

import pl.edu.pk.shop.database.*;

/**
 * @author Christopher Abram
 *
 */
public abstract class User {
	// vars {
		
		public UserData data = null;
		
		// czy to aby jest ok?
		protected String _sqlByID = 
				"SELECT " +
				"id, type, name, surname, age " +
				"FROM users " +
				"WHERE id = ? " +
				"FETCH FIRST 1 ROW ONLY";
		
		
	// } methods {
		
		// public {
		
			User(int ID){
				data = new UserData(ID);
			}
		
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
				db.query("SELECT id FROM users WHERE email = ? AND password = ? FETCH FIRST 1 ROW ONLY");
				db.prepare(new Object[]{login, password});
				
				db.execute();
				/*ResultSet rs = db.getResults();
				try {
					if(rs.first())
						id = rs.getInt("id");
					else
						System.out.println("Warning: User not exists...");
				} catch(SQLException e){
					System.out.println("Error: Unable to get user information!");
				}*/
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