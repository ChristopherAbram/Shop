package pl.edu.pk.shop.database;

import java.sql.*;

/**
 * Database connection singleton.
 * @version 0.1
 * @author Christopher Abram
 */
public final class Database {
	// vars {
		
		// Instances:
		private static Database __instance 		= null;
		private Connection __conn 				= null;
		private PreparedStatement __pstmt 		= null;
		
		// SQL Server connection parameters:
		private static String __username 		= "ii245";
		private static String __password 		= "oracleii";
		private static String __hostname 		= "149.156.136.151";
		private static String __port 			= "1521";
		private static String __SID 			= "orcl";
		private static String __connectionName 	= "JavaShopProject";
		
		// Maximum time in seconds:
		private static int __timeout 			= 10;
		
		// SQL query parameters:
		private String __sqlQuery				= "";
		
	// } methods {
		// public {
			
			/**[Singleton] Gets an instance of class Database.
			 * @author Christopher Abram
			 * @return Database - instance of class Database.
			 */
			public static Database getInstance(){
				if(__instance == null)
					__instance = new Database();
				return __instance;
			}// end getInstance
			
			/**Gets Connection instance. If not created, it creates one.
			 * @author Christopher Abram
			 * @return Connection - instance of newly created connection.
			 */
			public Connection getConnection(){
				connect();
				return __conn;
			}// end getConnection
			
			/**Establishes connection to a database. If something went wrong,
			 * displayes appropriate message.
			 * @author Christopher Abram
			 * @return Database - reference to this (fluent interface)
			 */
			public Database connect(){
				if(__conn == null){
					
					// Connection URL:
					String url = "jdbc:oracle:thin:@" + 
									__hostname + ":" + 
									__port + ":" + 
									__SID;
					
					String user = __username;
					String password = __password;
					
					try {
						DriverManager.setLoginTimeout(__timeout);
						__conn = DriverManager.getConnection(url, user, password);
					} catch(SQLTimeoutException sqlToE){
						System.out.println("Error: Login timeout!");
					} catch(SQLException sqlE){
						System.out.println("Error: Unable to establish connection!");
					}
				}
				return this;
			}// end connect
			
			/**Sets SQL query to be performed.
			 * @author Christopher Abram
			 * @return Database - reference to this (fluent interface)
			 */
			public Database query(String sql){
				__sqlQuery = sql;
				try {
					if(__conn != null)
						__pstmt = __conn.prepareStatement(__sqlQuery);
				} catch(SQLException e){
					System.out.println("Error: unable to create SQL query statement!");
				}
				return this;
			}// end query
			
			/**Prepares SQL with preparedStatement class.
			 * For each index in array values change query by setting appropriate key.
			 * @author Christopher Abram
			 * @return Database - reference to this (fluent interface)
			 */
			public Database prepare(Object... values){
				if(__pstmt != null){
					try {
						int i = 1;
						for(Object ob : values){
							switch(_getClassName(ob)){
								case "Character":
									__pstmt.setString(i, ob.toString());
									break;
								case "Byte":
									__pstmt.setString(i, ob.toString());
									break;
								case "Short":
									__pstmt.setInt(i, (short)ob);
									break;
								case "Integer":
									__pstmt.setInt(i, (int)ob);
									break;
								case "Long":
									__pstmt.setLong(i, (long)ob);
									break;
								case "Float":
									__pstmt.setFloat(i, (float)ob);
									break;
								case "Double":
									__pstmt.setDouble(i, (double)ob);
									break;
								case "String":
									__pstmt.setString(i, (String)ob);
									break;
								default:
									__pstmt.setString(i, ob.toString());
							}
							++i;
						}
					} catch(SQLException e){
						System.out.println("Error: unable to prepare SQL statement!");
					}
				}
				return this;
			}// end prepare
			
			/**Executes SQL query.
			 * @author Christopher Abram
			 * @return boolean - true if query executes properly or false otherwise.
			 */
			public boolean execute(){
				boolean p = false;
				try {
					
					// Decide the type of query:
					String query = "";
					try {
						query = __sqlQuery.substring(0, 6);
					} catch(IndexOutOfBoundsException ioobe){
						query = "";
					}
					query = query.toLowerCase();
					
					//System.out.println(query);
					
					if(query.equals(""))
						return p;
					else if(query.equals("select"))
						p = __pstmt.execute();
					else if(query.equals("update") || query.equals("insert") || query.equals("delete")){
						int r = __pstmt.executeUpdate();
						p = r > 0;
					}
				} catch(SQLException e){
					System.out.println("Error: unable to execute SQL query!");
				}
				return p;
			}// end execute
			
			/**Gets results from database.
			 * @author Christopher Abram
			 * @return ResultSet - the results of select query.
			 **/
			public Results getResults() throws DatabaseException {
				try {
					ResultSet rs = __pstmt.getResultSet();
					return new Results(rs);
				} catch(SQLException e){
					throw new DatabaseException("Error: unable to get results!");
				}
			}// end getResults
			
			/** Closes database connection.
			 * @author Christopher Abram
			 * @return boolan - true if ok, otherwise false.
			 * @thorws DatabaseException - when unable to close.
			 **/
			public boolean close(){
				boolean p = false;
				if(__pstmt != null){
					try {
						__pstmt.close();
						p = true;
					} catch(SQLException e){
						p = false;
						throw new DatabaseException("Error: unable to close SQL connection!");
					}
				}
				if(__conn != null){
					try {
						__conn.close();
						p &= true;
					} catch(SQLException e){
						p &= false;
						throw new DatabaseException("Error: unable to close SQL connection!");
					}
				}
				return p;
			}// end close
			
		// } protected {
			
			protected static String _getClassName(Object ob){
				return ob.getClass().getSimpleName();
			}// end getClassName
			
		// } private {
			
			/**Database constructor.
			 * @version 0.1
			 * @author Christopher Abram
			 **/
			private Database(){
				// Registration of oracle jdbc driver:
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				}
				catch(ClassNotFoundException ex) {
					System.out.println("Error: unable to load driver class!");
					System.exit(1);
				}
			}
			
		// }
	// }
}