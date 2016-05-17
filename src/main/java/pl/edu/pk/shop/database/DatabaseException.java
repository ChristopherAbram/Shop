package pl.edu.pk.shop.database;

/** 
 * DatabaseException - handling exceptions related with database operations
 * @author Christopher Abram
 * @see RuntimeException
 **/
public class DatabaseException extends RuntimeException {
	// vars {
		
	// } methods {
		// public {
			
			public DatabaseException(){
				super();
			}
	
			public DatabaseException(String message){
				super(message);
			}
			
			public DatabaseException(String message, Throwable cause){
				super(message, cause);
			}
			
			public DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
				super(message, cause, enableSuppression, writableStackTrace);
			}
			
			public DatabaseException(Throwable cause){
				super(cause);
			}
	
		// } protected {
			
		// } private {
			
		// }
	// }
}
