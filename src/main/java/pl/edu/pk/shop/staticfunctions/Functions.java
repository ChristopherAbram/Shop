package pl.edu.pk.shop.staticfunctions;

/** Functions - a class containing methods not connected 
 * with specific responsibility. 
 * @author Christopher Abram
 **/
public final class Functions {
	// vars {
	
	// } methods {
		// public {
			
			/** Prints any object to standard output stream and append new line character.
			 * @author Christopher Abram
			 * @param Object - an object to be printed
			 **/
			public static void println(Object o){
				System.out.println(o);
				return;
			}// end println
			
			/** Prints any object to standard output stream.
			 * It does not add any characters, even new line feed.
			 * @author Christopher Abram
			 * @param Object - an object to be printed
			 **/
			public static void print(Object o){
				System.out.print(o);
				return;
			}// end print
			
			/** Prints objects to standard output stream adding new line 
			 * char after each object.
			 * @author Christopher Abram
			 * @param Object... - objects to be printed
			 **/
			public static void mprintln(Object... o){
				for(Object x : o)
					System.out.println(x);
				return;
			}// end mprintln
			
			/** Prints objects to standard output stream without new line character.
			 * @author Christopher Abram
			 * @param Object... - objects to be printed
			 **/
			public static void mprint(Object... o){
				for(Object x : o)
					System.out.print(x);
				return;
			}// end mprint
			
		// } protected {
		
		// } private {
		
		// }
	// }
}
